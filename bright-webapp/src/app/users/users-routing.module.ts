import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsersNavigationComponent } from './users-navigation/users-navigation.component';
import { UsersListComponent } from './users-list/users-list.component';
import { UsersComponent } from './users.component';


const routes: Routes = [
  { path: '', outlet: 'leftNav', component: UsersNavigationComponent },
  { path: '', component: UsersComponent,
      children: [
        { path: 'groups', component: UsersListComponent }, // Replace with Groups Feature
        { path: 'connections', component: UsersListComponent }
      ]
  },
  { path: ':id', loadChildren: () => import ('../user/user.module').then(m => m.UserModule) },
 ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsersRoutingModule { }
