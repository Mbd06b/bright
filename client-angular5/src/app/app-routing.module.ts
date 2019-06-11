import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { LandingComponent } from './landing/landing.component';
import { NavComponent } from './nav/nav.component';
import { AdminComponent } from './admin/admin.component';
import { UsersComponent } from './admin/users/users.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { IdeasComponent } from './admin/ideas/ideas.component';
import { RegisterComponent } from './register/register.component';
import { ProfileComponent } from './profile/profile.component';
import { IdeaDetailComponent } from './idea-detail/idea-detail.component';

const routes: Routes = [
  { path: '' , component: LandingComponent },
  { path: 'landing', component: LandingComponent },
  // TODO public parameterized route { path: 'idea/:id', component: IdeaFocusComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'home', component: NavComponent,
    children: [
      {path: 'ideas', component: DashboardComponent},
      {path: 'people', component: UsersComponent},
      {path: 'people/:id', component: ProfileComponent},
      {path: 'ideas/:id', component: IdeaDetailComponent},
      {path: 'admin', component: AdminComponent,
        children: [
          { path: 'users', component: UsersComponent },
          { path: 'ideas', component: IdeasComponent }
          ]
       },
      ]
  },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
