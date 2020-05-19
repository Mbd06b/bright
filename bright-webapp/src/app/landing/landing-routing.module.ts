import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { LandingComponent } from './landing.component';

const routes: Routes = [
  {  path: '', component: LandingComponent,
    children: [
      { path: 'signup', loadChildren: () => import('../register/register.module').then(m => m.RegisterModule) },
      { path: '', loadChildren: () => import('../login/login.module').then(m => m.LoginModule)},
      { path: 'signin', loadChildren: () => import('../login/login.module').then(m => m.LoginModule)}

    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class LandingRoutingModule {}
