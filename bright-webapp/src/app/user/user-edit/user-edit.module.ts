import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserEditRoutingModule } from './user-edit-routing.module';
import { UserEditComponent } from './user-edit.component';


@NgModule({
  declarations: [UserEditComponent],
  imports: [
    CommonModule,
    UserEditRoutingModule
  ]
})
export class UserEditModule { }
