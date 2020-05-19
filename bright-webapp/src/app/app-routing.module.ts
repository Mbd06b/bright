import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsersComponent } from './users/users.component';
import { IdeasComponent } from './ideas/ideas.component';
import { UserProfileComponent } from './user/user-profile/user-profile.component';
import { IdeaComponent } from './idea/idea.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { NavigationComponent } from './bright/navigation/navigation.component';


const routes: Routes = [
{ path: '' , loadChildren: () => import('./landing/landing.module').then(m => m.LandingModule) },
{ path: 'landing', loadChildren: () => import('./landing/landing.module').then(m => m.LandingModule)},
{ path: 'register', loadChildren: () => import('./register/register.module').then(m => m.RegisterModule) },
{ path: 'login', loadChildren: () => import('./login/login.module').then(m => m.LoginModule)},
{ path: 'bright', loadChildren: () => import('./bright/bright.module').then(m => m.BrightModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
