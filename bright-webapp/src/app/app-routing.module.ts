import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
{ path: '' , loadChildren: () => import('./landing/landing.module').then(m => m.LandingModule) },
{ path: 'landing', redirectTo: '', pathMatch: 'full' },
{ path: 'register', loadChildren: () => import('./register/register.module').then(m => m.RegisterModule) },
{ path: 'login', loadChildren: () => import('./login/login.module').then(m => m.LoginModule)},
{ path: 'bright', loadChildren: () => import('./bright/bright.module').then(m => m.BrightModule) }
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      routes,
     // uncomment for router debug
     // { enableTracing: true }
    )
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
