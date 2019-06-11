import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { map } from 'rxjs/operators';

import * as jwt_decode from 'jwt-decode';

import { AppSettings } from '../app.settings';
import { User } from '../model/user';
import { routerNgProbeToken } from '@angular/router/src/router_module';
import { AnimationStyleMetadata } from '@angular/animations';
import { Observable } from 'rxjs/Observable';
import { inspect } from 'util';
import { validateConfig } from '@angular/router/src/config';

// design pattern refrenced, https://dzone.com/articles/angular-5-material-design-login-application
@Injectable()
export class AuthService {

  TOKEN_KEY = 'token';
  sessionToken: string;
  sessionUser: User;

  constructor(
    private router: Router,
    private http: HttpClient
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
      return this.http.post<boolean>(AppSettings.API_URL + '/auth/token', this.sessionToken)
            .do( response => {
                // header switch handling
                console.log(response);
                return response.valueOf;
            });
    }

    login(user: User) {
        return this.http.post<User>(AppSettings.API_URL + '/auth/', user)
            .do( userData => {
                // login successful if there's a jwt token in the response
                if  (userData && userData.token) {
                    // store user jwt token in local storage to keep user logged in between page refreshes
                    // token subject == database generated user id
                    localStorage.setItem(this.TOKEN_KEY, userData.token);
                    this.sessionToken = userData.token;
                    this.sessionUser = userData;
                    // object inspection for Testing Purposes
                }
                return userData;
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



