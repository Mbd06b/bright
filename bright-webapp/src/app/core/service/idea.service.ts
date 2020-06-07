
import {of as observableOf, Observable} from 'rxjs';

import {catchError, tap} from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { inspect } from 'util';
import { Idea } from '../model/idea';
import { IdeaAction } from '../model/ideaaction.enum';
import { AppConstants } from '../app-constants';
import { NGXLogger } from 'ngx-logger';
import { AuthenticationService } from './authentication.service';




@Injectable()
export class IdeaService {
// Design pattern notes See user.service.ts:
ideasApi = AppConstants.API_URL + '/idea/';

  constructor(
    private logger: NGXLogger,
    private httpClient: HttpClient,
    private authService: AuthenticationService,
    ) { }



  getIdeas(): Observable<Idea[]> {
    return this.httpClient.get(this.ideasApi + 'ideas').pipe(
      tap(() => this.logger.debug('getIdeas: ')),
      catchError(this.handleError<any>('getIdeas')), );
  }

  getIdeaById(id: number): Observable<Idea> {
    return this.httpClient.get(this.ideasApi + id).pipe(
      tap(data => this.logger.debug('getIdea[' + id + ']: ' + inspect(data))),
      catchError(this.handleError<any>('getIdea[' + id + ']')), );
  }

  getIdeasByUserId(userId: number): Observable<Idea[]> {
    return this.httpClient.get(this.ideasApi + 'user/' + userId).pipe(
      tap(data => this.logger.debug('getIdea[' + userId + ']: ' + inspect(data))),
      catchError(this.handleError<any>('getIdea[' + userId + ']')), );
  }

  postIdea(idea: Idea): Observable<Idea> {
       idea.actingEntityId = this.authService.currentUser.id;
       idea.action = IdeaAction.Create;
       return this.httpClient.post(this.ideasApi, idea).pipe(
      tap(data => this.logger.debug('postIdea: ' + inspect(data))),
      catchError(this.handleError<any>('postIdea')), );
  }

  deleteIdea(id: number): Observable<Idea> {
    return this.httpClient.delete(this.ideasApi + id).pipe(
      tap(data => this.logger.debug('deleteIdea[id:' + id + ']:' + inspect(data))),
      catchError(this.handleError<any>('deleteIdea')), );
  }


  updateIdea(idea: Idea): Observable<Idea> {
    // set default if not provided.
    if ( (idea.action === undefined) || (idea.action === null) ) {
      idea.action = IdeaAction.Update;
     }

    // leave the actingUserId alone if it has been explictly defined.
    if ( (idea.actingEntityId !== undefined) || (idea.actingEntityId !== null) ) {
       // do nothing
     } else {
      idea.actingEntityId = this.authService.currentUser.id;
     }

    return this.httpClient.put(this.ideasApi, idea).pipe(
      tap(() => this.logger.debug('updated idea w/ id={idea.id}')),
      catchError(this.handleError<any>('updateIdea')), );
  }


  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      this.logger.error(error);

      // Let the app keep running by returning an empty result.
      return observableOf(result);
    };
  }

}
