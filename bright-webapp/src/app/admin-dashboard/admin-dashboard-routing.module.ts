import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard.component';
import { IdeasListComponent } from '../ideas/ideas-list/ideas-list.component';
import { UsersListComponent } from '../users/users-list/users-list.component';


const routes: Routes = [
  { path: '', component: AdminDashboardComponent,
        children: [
          { path: 'ideas', component: IdeasListComponent },
          { path: 'users', component: UsersListComponent }
        ]
   },
   { path: '', component: UsersListComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminDashboardRoutingModule { }
