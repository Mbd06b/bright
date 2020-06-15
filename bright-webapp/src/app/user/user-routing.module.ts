import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserComponent } from './user.component';
import { UserResolver } from '../core/service/user.resolver';
import { UserActivityComponent } from './user-activity/user-activity.component';
import { UserDetailComponent } from './user-detail/user-detail.component';
import { UserIdeasComponent } from './user-ideas/user-ideas.component';


const routes: Routes = [
  { path: '' , component: UserComponent, resolve: { user: UserResolver },
    children: [
      { path: '' , component: UserActivityComponent },
      { path: 'activity' , component: UserActivityComponent },
      { path: 'ideas',  loadChildren: () => import('./user-ideas/user-ideas.module').then(m => m.UserIdeasModule) },
      { path: 'about', component: UserDetailComponent }
    ]
  },
  { path: '', outlet: 'secondary' , component: UserIdeasComponent, pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
