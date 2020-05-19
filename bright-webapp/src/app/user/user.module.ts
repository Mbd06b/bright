import { NgModule } from '@angular/core';

import { UserRoutingModule } from './user-routing.module';
import { UserComponent } from './user.component';
import { UserListComponent } from './user-list/user-list.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [UserComponent, UserListComponent],
  imports: [
    SharedModule,
    UserRoutingModule
  ]
})
export class UserModule { }
