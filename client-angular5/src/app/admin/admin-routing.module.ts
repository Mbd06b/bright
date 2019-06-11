import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

import { IdeasComponent } from './ideas/ideas.component';
import { UsersComponent } from './users/users.component';
import { AdminComponent } from './admin.component';

const routes: Routes = [{
    path: 'home/admin',
    component: AdminComponent,
    children: [
      { path: 'users', component: UsersComponent },
      { path: 'ideas', component: IdeasComponent }
    ]}
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
