import { NgModule } from '@angular/core';

import { UsersRoutingModule } from './users-routing.module';
import { UsersComponent } from './users.component';

import { UsersGridComponent } from './users-grid/users-grid.component';
import { UsersListComponent } from './users-list/users-list.component';
import { UsersCardComponent } from './users-card/users-card.component';
import { SharedModule } from '../shared/shared.module';
import { UserListComponent } from '../user/user-list/user-list.component';
import { UserAddDialogueComponent } from './user-add-dialogue/user-add-dialogue.component';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatTabsModule } from '@angular/material/tabs';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatDialogModule } from '@angular/material/dialog';
import { MatSelectModule } from '@angular/material/select';
import { MatOptionModule } from '@angular/material/core';
import { MatButtonModule } from '@angular/material/button';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { UserEditDialogueComponent } from './user-edit-dialogue/user-edit-dialogue.component';


@NgModule({
  declarations: [UsersComponent, UsersGridComponent, UsersListComponent, UsersCardComponent, UserAddDialogueComponent, UserEditDialogueComponent],
  imports: [
    SharedModule,
    UsersRoutingModule,
    FormsModule,
    MatCardModule,
    MatTabsModule,
    MatFormFieldModule,
    MatPaginatorModule,
    MatTableModule,
    MatInputModule,
    MatDialogModule,
    MatSelectModule,
    MatOptionModule,
    MatButtonModule,
    MatMenuModule,
    MatIconModule
  ]
})
export class UsersModule { }
