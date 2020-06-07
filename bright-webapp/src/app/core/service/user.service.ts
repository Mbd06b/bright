
import {of as observableOf, Observable} from 'rxjs';

import {catchError, tap} from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { inspect } from 'util';
import { User } from '../model/user';
import { AppConstants } from '../app-constants';

import { NGXLogger } from 'ngx-logger';

// Design patterns referenced:
// Deborah Kurata (best practice using @angular/http library)
// https://stackoverflow.com/questions/43689478/angular-2-best-practices-to-get-data-from-json-or-api
//
// using @angular/common/http library, and rxjs .pipe() method:
// https://www.djamware.com/post/5b87894280aca74669894414/angular-6-httpclient-consume-restful-api-example
// discussion of this implementation https://stackoverflow.com/questions/48030197/what-is-pipe-function-in-angular-2
// example on upgrade from http https://www.telerik.com/blogs/updating-to-angular-httpclient-simpler-http-calls

@Injectable()
export class UserService {

  private usersApi = AppConstants.API_URL + '/user/';

  constructor(
    private logger: NGXLogger,
    private httpClient: HttpClient
    ) { }

  getUsers(): Observable<User[]> {
    return this.httpClient.get(this.usersApi + 'all').pipe(
      tap(() => this.logger.debug('getUsers: ')),
      catchError(this.handleError<any>('getUsers')), );
  }

  getUserByToken(token: string): Observable<User> {
    return this.httpClient.post(this.usersApi + '/login/token', token).pipe(
      tap(data => this.logger.debug('getUser[]:')),
      catchError(this.handleError<any>('getUserByToken()')), );
  }

  getUserById(id: number): Observable<User> {
    return this.httpClient.get(this.usersApi + id).pipe(
      tap(data => this.logger.debug('getUser[' + id + ']: ' + inspect(data))),
      catchError(this.handleError<any>('getUser[' + id + ']')), );
  }

  getUserByEmail(email: string): Observable<User> {
    return this.httpClient.get(this.usersApi + 'email/' +  email).pipe(
      tap(data => this.logger.debug('getUser[' + email + ']: ' + inspect(data))),
      catchError(this.handleError<any>('getUser[' + email + ']')), );
  }

  postUser(user: User): Observable<User> {
    return this.httpClient.post(this.usersApi, user).pipe(
      tap(data => this.logger.debug('postUser: ' + inspect(data))),
      catchError(this.handleError<any>('postUser')), );
  }

  deleteUser(id: number): Observable<User> {
    return this.httpClient.delete(this.usersApi + id).pipe(
      tap(data => this.logger.debug('deleteUser[id:' + id + ']:' + inspect(data))),
      catchError(this.handleError<any>('deleteUser')), );
  }


  updateUser(user: User): Observable<User> {
    return this.httpClient.put(this.usersApi, user).pipe(
      tap(() => this.logger.debug('updated user w/ id=${user.id}')),
      catchError(this.handleError<any>('updateUser')), );
  }

  existsById(id: number): Observable<boolean> {
    return this.httpClient.get(this.usersApi + 'exists/' + id).pipe(
      tap(() => this.logger.debug('checking for user w/ identifier=${id}')),
      catchError(this.handleError<any>('existsById')), );
  }

  existsByEmail(email: string): Observable<boolean> {
    return this.httpClient.get(this.usersApi + 'exists/' + email).pipe(
      tap(() => this.logger.debug('checking for user w/ identifier=${email}')),
      catchError(this.handleError<any>('existsByEmail')), );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      this.logger.error(error);

      // Let the app keep running by returning an empty result.
      return observableOf(result);
    };
  }

}
