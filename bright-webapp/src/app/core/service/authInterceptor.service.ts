import { Injectable, Injector } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';

import { Observable } from 'rxjs';
import { NGXLogger } from 'ngx-logger';
import { AuthenticationService } from './authentication.service';

// pattern following:
// tslint:disable-next-line:max-line-length
// https://app.pluralsight.com/player?course=building-angular-application-node-token-authentication&author=alex-zanfir&name=building-angular-application-mean-stack-m9&clip=3&mode=live


@Injectable()
export class AuthInterceptorService implements HttpInterceptor {

  constructor(
    private logger: NGXLogger,
    private injector: Injector
  ) { }


 intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
   const authService = this.injector.get(AuthenticationService);
   const authRequest = request.clone({
     headers: request.headers.set('Authorization', 'token' + authService.token)
   });
   if (authService.isTokenValid() ) {
     return next.handle(authRequest);
   }
   return next.handle(authRequest);
 }

}
