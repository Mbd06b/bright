import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/observable';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/of';

import { inspect } from 'util';

import { AppSettings } from '../app.settings';
import { User } from '../model/user';

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

  private usersApi = AppSettings.API_URL + '/user/';


  getUsers(): Observable<User[]> {
    return this.httpClient.get(this.usersApi + 'users')
      .do(() => console.log('getUsers: '))
      .catch(this.handleError<any>('getUsers'));
  }

  getUserById(id: number): Observable<User> {
    return this.httpClient.get(this.usersApi + id)
      .do(data => console.log('getUser[' + id + ']: ' + inspect(data)))
      .catch(this.handleError<any>('getUser[' + id + ']'));
  }

  getUserByEmail(email: string): Observable<User> {
    return this.httpClient.get(this.usersApi + 'email/' +  email)
      .do(data => console.log('getUser[' + email + ']: ' + inspect(data)))
      .catch(this.handleError<any>('getUser[' + email + ']'));
  }

  postUser(user: User): Observable<User> {
    return this.httpClient.post(this.usersApi, user)
      .do(data => console.log('postUser: ' + inspect(data)))
      .catch(this.handleError<any>('postUser'));
  }

  deleteUser(id: number): Observable<User> {
    return this.httpClient.delete(this.usersApi + id)
      .do(data => console.log('deleteUser[id:' + id + ']:' + inspect(data)))
      .catch(this.handleError<any>('deleteUser'));
  }


  updateUser(user: User): Observable<User> {
    return this.httpClient.put(this.usersApi, user)
      .do(() => console.log('updated user w/ id=${user.id}'))
      .catch(this.handleError<any>('updateUser'));
  }

  existsById(id: number): Observable<Boolean> {
    return this.httpClient.get(this.usersApi + 'exists/' + id)
      .do(() => console.log('checking for user w/ identifier=${id}'))
      .catch(this.handleError<any>('existsById'));
  }

  existsByEmail(email: string): Observable<Boolean> {
    return this.httpClient.get(this.usersApi + 'exists/' + email)
      .do(() => console.log('checking for user w/ identifier=${email}'))
      .catch(this.handleError<any>('existsByEmail'));
  }




  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return Observable.of(result);
    };
  }

  constructor(private httpClient: HttpClient) { }
}
