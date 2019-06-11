import { NgModule } from '@angular/core';
import { LayoutModule } from '@angular/cdk/layout';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';

import {
  MatToolbarModule,
  MatButtonModule,
  MatSidenavModule,
  MatIconModule,
  MatListModule,
  MatGridListModule,
  MatCardModule,
  MatMenuModule,
  MatTabsModule,
  MatFormFieldModule,
  MatInputModule,
  MatButtonToggle,
  MatButtonToggleModule
} from '@angular/material';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingComponent } from './landing/landing.component';
import { LoginComponent } from './login/login.component';
import { NavComponent } from './nav/nav.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AdminModule } from './admin/admin.module';
import { RegisterComponent } from './register/register.component';
import { AuthService } from './service/auth.service';
import { AlertService } from './service/alert.service';
import { UserService } from './service/user.service';
import { IdeaService } from './service/idea.service';
import { AuthInterceptorService } from './service/authInterceptor.service';
import { ProfileComponent } from './profile/profile.component';
import { IdeaDetailComponent } from './idea-detail/idea-detail.component';



@NgModule({
  declarations: [
    AppComponent,
    LandingComponent,
    NavComponent,
    DashboardComponent,
    LoginComponent,
    RegisterComponent,
    ProfileComponent,
    IdeaDetailComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    LayoutModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
    MatToolbarModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatGridListModule,
    MatCardModule,
    MatMenuModule,
    MatFormFieldModule,
    MatInputModule,
    MatTabsModule,
    AppRoutingModule,
    AdminModule
  ],
  providers: [
    AuthService,
    { provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptorService,
      multi: true
    },
    AlertService,
    UserService,
    IdeaService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
  title = 'BrightIdeas';
}
