import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BrightComponent } from './bright.component';
import { UsersComponent } from '../users/users.component';
import { UserProfileComponent } from '../user/user-profile/user-profile.component';
import { IdeaComponent } from '../idea/idea.component';
import { AdminDashboardComponent } from '../admin-dashboard/admin-dashboard.component';
import { IdeasComponent } from '../ideas/ideas.component';

const routes: Routes = [
  { path: '', component: BrightComponent,
      children: [
       // { path: 'users', outlet: 'bright',  component: UsersComponent },
        { path: 'ideas', component: IdeasComponent },
        { path: 'admin', loadChildren: () => import('../admin-dashboard/admin-dashboard.module').then(m => m.AdminDashboardModule) },
      ]
  },
  { path: 'people', component: UsersComponent},
  { path: 'people/:id', component: UserProfileComponent},
  { path: 'ideas/:id', component: IdeaComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BrightRoutingModule { }
