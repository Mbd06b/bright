import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


import { AppSettings } from '../app.settings';
import { AuthRequest } from '../model/authRequest';
import { AuthResponse } from '../model/authResponse';
import { User } from '../model/user';
import { UserService } from './user.service';

const AUTH_URL: string = AppSettings.API_URL + '/auth/';

// design pattern refrenced, https://dzone.com/articles/angular-5-material-design-login-application
@Injectable()
export class AuthService {

  TOKEN_KEY = 'token';
  sessionToken: string;
  sessionUser: User;

  constructor(
    private router: Router,
    private http: HttpClient,
    private userService: UserService
    ) { }

    get token(): string {
      return this.sessionToken;
    }

    get isAuthenticated(): boolean {
      if (!!this.sessionToken) {
            return true;
          } else {
            return false;
          }

    }

    isTokenValid() {
      return this.http.post<boolean>(AUTH_URL + 'token', this.sessionToken)
            .do( response => {
                // header switch handling
                console.log(response);
                return response.valueOf;
            });
    }

    login(authRequest: AuthRequest) {
        return this.http.post<AuthResponse>(AUTH_URL, authRequest)
        .do( loginResponse => {
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
        });
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



