import { NgModule } from '@angular/core';
import { UserListComponent } from './user-list.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { UserIdeasComponent } from '../user-ideas/user-ideas.component';
import { UserEditComponent } from '../user-edit/user-edit.component';



@NgModule({
  declarations: [UserListComponent, UserIdeasComponent, UserEditComponent],
  imports: [
    SharedModule
  ]
})
export class UserListModule { }
