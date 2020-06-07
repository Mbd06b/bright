import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BrightComponent } from './bright.component';

const routes: Routes = [
  { path: '', component: BrightComponent,
      children: [
       // { path: 'users', outlet: 'bright',  component: UsersComponent },
        { path: 'ideas', loadChildren: () => import('../ideas/ideas.module').then(m => m.IdeasModule) },
        { path: 'admin', loadChildren: () => import('../admin-dashboard/admin-dashboard.module').then(m => m.AdminDashboardModule) },
        { path: 'people', loadChildren: () => import ('../users/users.module').then(m => m.UsersModule) },
        { path: 'people/:id', loadChildren: () => import ('../user/user.module').then(m => m.UserModule) },
        { path: 'ideas/:id', loadChildren: () => import('../ideas/ideas.module').then(m => m.IdeasModule) }
      ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BrightRoutingModule { }
