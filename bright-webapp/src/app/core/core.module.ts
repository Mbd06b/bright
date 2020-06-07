import { NgModule, Optional, SkipSelf } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { EnsureModuleLoadedOnceGuard } from './ensure-module-loaded-once.guard';
import { AuthenticationService } from './service/authentication.service';
import { AuthInterceptor } from './interceptors/auth.interceptor';
import { UserService } from './service/user.service';
import { IdeaService } from './service/idea.service';
import { AlertService } from './service/alert.service';
import { SharedModule } from '../shared/shared.module';
import { CookieService } from 'ngx-cookie-service';

@NgModule({
  declarations: [],
  imports: [
    SharedModule,
  ],
  exports: [
    HttpClientModule,
  ],
  providers: [
    AuthenticationService, UserService, IdeaService, AlertService, CookieService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    },
  ]
})
export class CoreModule extends EnsureModuleLoadedOnceGuard {

  // Looks for the module in the parent injector to see if it's already been loaded (only want it loaded once)
  constructor(@Optional() @SkipSelf() parentModule: CoreModule) {
    super(parentModule);
  }
 }
