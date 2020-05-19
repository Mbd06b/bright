import { Injectable } from '@angular/core';
import { User } from '../model/user';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { AuthRequest } from '../model/authRequest';
import { AuthResponse } from '../model/authResponse';
import { UserService } from './user.service';
import { tap } from 'rxjs/operators';
import { AppConstants } from '../app-constants';
import { NGXLogger } from 'ngx-logger';


const AUTH_URL: string = AppConstants.API_URL + '/auth/';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  TOKEN_KEY = 'token';
  sessionToken: string;
  sessionUser: User;

  constructor(
    private logger: NGXLogger,
    private router: Router,
    private http: HttpClient,
    private userService: UserService
    ) { }

    get token(): string {
      return this.sessionToken;
    }

    get isAuthenticated(): boolean {


      if (!!this.sessionToken || this.isTokenValid) {

            return true;
          } else {
            return false;
          }

    }

    isTokenValid() {
      let storedToken = localStorage.getItem(this.TOKEN_KEY);
      return this.http.post<boolean>(AUTH_URL + 'token', storedToken).pipe(
            tap( response => {
                // header switch handling
                this.logger.debug(response);
                return response.valueOf;
            }));
    }

    login(authRequest: AuthRequest) {
        return this.http.post<AuthResponse>(AUTH_URL, authRequest).pipe(
        tap( loginResponse => {
            // login successful if there's a jwt token in the response
            if  (loginResponse.jwt) {

                // store user jwt token in local storage to keep user logged in between page refreshes
                // token subject == database generated user id
                localStorage.setItem(this.TOKEN_KEY, loginResponse.jwt);
                this.sessionToken = loginResponse.jwt;
                this.userService.getUserByEmail(authRequest.key).subscribe( (data) => {
                   this.sessionUser = data;
                });
            }
            return this.sessionUser;
        }));
    }


    logout() {
        // remove user and token from session
        this.sessionToken = '';
        this.sessionUser = null;
        this.router.navigate(['landing']);
    }

    get currentUser(): User {

      if (this.isAuthenticated) {
        return this.sessionUser;
      }
      this.logout();
      return null;
      }
}
