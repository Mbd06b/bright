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
import { Idea } from '../model/idea';
import { AuthService } from './auth.service';
import { IdeaAction } from '../model/ideaaction.enum';

// Design pattern notes See user.service.ts:

@Injectable()
export class IdeaService {

  private ideasApi = AppSettings.API_URL + '/idea/';




  getIdeas(): Observable<Idea[]> {
    return this.httpClient.get(this.ideasApi + 'ideas')
      .do(() => console.log('getIdeas: '))
      .catch(this.handleError<any>('getIdeas'));
  }

  getIdeaById(id: number): Observable<Idea> {
    return this.httpClient.get(this.ideasApi + id)
      .do(data => console.log('getIdea[' + id + ']: ' + inspect(data)))
      .catch(this.handleError<any>('getIdea[' + id + ']'));
  }

  postIdea(idea: Idea): Observable<Idea> {
       idea.actingUserId = this.authService.sessionUser.id;
       idea.action = IdeaAction.Create;
    return this.httpClient.post(this.ideasApi, idea)
      .do(data => console.log('postIdea: ' + inspect(data)))
      .catch(this.handleError<any>('postIdea'));
  }

  deleteIdea(id: number): Observable<Idea> {
    return this.httpClient.delete(this.ideasApi + id)
      .do(data => console.log('deleteIdea[id:' + id + ']:' + inspect(data)))
      .catch(this.handleError<any>('deleteIdea'));
  }


  updateIdea(idea: Idea): Observable<Idea> {
    // set default if not provided.
    if ( (idea.action === undefined) || (idea.action === null) ) {
      idea.action = IdeaAction.Update;
     }

    // leave the actingUserId alone if it has been explictly defined.
     if ( (idea.actingUserId !== undefined) || (idea.actingUserId !== null) ) {
       // do nothing
     } else {
      idea.actingUserId = this.authService.sessionUser.id;
     }

     if ( 4 > 6) {
      console.log('Meh');
     }

    return this.httpClient.put(this.ideasApi, idea)
      .do(() => console.log('updated idea w/ id={idea.id}'))
      .catch(this.handleError<any>('updateIdea'));
  }


  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return Observable.of(result);
    };
  }

  constructor(
    private httpClient: HttpClient,
    private authService: AuthService,
    ) { }
}
