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
import { Observable } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';


const AUTH_URL: string = AppConstants.API_URL + '/auth/';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private cookieValue: string;
  private TOKEN_KEY = 'token';
  sessionToken: string;
  sessionUser: User;

  constructor(
    private logger: NGXLogger,
    private router: Router,
    private http: HttpClient,
    private cookieService: CookieService,
    private userService: UserService
    ) { }

    get token(): string {
      return this.sessionToken;
    }

    get isAuthenticated(): boolean {
      if ( (this.sessionToken === null) || (this.sessionToken === undefined) ) {
        const localToken = localStorage.getItem(this.TOKEN_KEY);
        this.sessionToken = localToken;
      }

      if ( (this.sessionToken === null)
            || (this.sessionToken === undefined)
            || (this.currentUser === null)
            || (this.currentUser === undefined)
          ) {
        return false;
      } else {
        return true;
      }
    }

    isTokenValid() {
      const localToken = localStorage.getItem(this.TOKEN_KEY);
      if ( (localToken === null) || (localToken === undefined) ) {
        this.logger.debug('localToken not set');
        return false;
      } else {
        return this.http.post<boolean>(AUTH_URL + 'token', localToken).pipe(
          tap( response => {
              // header switch handling
              this.logger.debug(response);

              if ( response.valueOf ) {
                this.sessionToken = localToken;
              }
              return response.valueOf;
          }));
      }

    }

    login(authRequest: AuthRequest) {
        return this.http.post<AuthResponse>(AUTH_URL, authRequest).pipe(
        tap( loginResponse => {
            // login successful if there's a jwt token in the response
            if (loginResponse.jwt) {

                // store user jwt token in local storage to keep user logged in between page refreshes
                // token subject == database generated user id
                localStorage.setItem(this.TOKEN_KEY, loginResponse.jwt);
                sessionStorage.setItem(this.TOKEN_KEY, loginResponse.jwt);
                this.sessionToken = loginResponse.jwt;
                this.userService.getUserByToken(loginResponse.jwt).subscribe(user => {
                  this.sessionUser = user;
                  sessionStorage.setItem('user', JSON.stringify(user));

                });
            }
            return this.sessionUser;
        }));
    }

    logout() {
        // remove user and token from session
        this.sessionToken = null;
        localStorage.removeItem(this.TOKEN_KEY);
        sessionStorage.removeItem('user');
        sessionStorage.removeItem(this.TOKEN_KEY);
        this.sessionUser = null;
        this.router.navigate(['']);
    }

    get currentUser(): User {
      return JSON.parse(sessionStorage.getItem('user'));
    }
};
