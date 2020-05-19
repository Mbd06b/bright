import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserIdeasRoutingModule } from './user-ideas-routing.module';
import { UserIdeasComponent } from './user-ideas.component';


@NgModule({
  declarations: [UserIdeasComponent],
  imports: [
    CommonModule,
    UserIdeasRoutingModule
  ]
})
export class UserIdeasModule { }
