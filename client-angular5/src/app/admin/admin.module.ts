import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import {
  MatCardModule,
  MatTabsModule,
  MatPaginatorModule,
  MatTableModule,
  MatFormFieldModule,
  MatInputModule,
  MatDialogModule,
  MatButtonModule,
  MatMenuModule,
  MatIconModule,
  MatOptionModule,
  MatSelectModule
} from '@angular/material';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { UsersComponent } from './users/users.component';
import { IdeasComponent } from './ideas/ideas.component';
import { UserAddDialogComponent } from './users/user-add-dialog/user-add-dialog.component';
import { UserEditDialogComponent } from './users/user-edit-dialog/user-edit-dialog.component';
import { UserService } from '../service/user.service';
import { IdeaService } from '../service/idea.service';
import { IdeaAddDialogComponent } from './ideas/idea-add-dialog/idea-add-dialog.component';
import { IdeaEditDialogComponent } from './ideas/idea-edit-dialog/idea-edit-dialog.component';

@NgModule({
  imports: [
    FormsModule,
    CommonModule,
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
    MatIconModule,
    AdminRoutingModule
  ],
  declarations: [
    AdminComponent,
    UsersComponent,
    IdeasComponent,
    UserAddDialogComponent,
    UserEditDialogComponent,
    IdeaAddDialogComponent,
    IdeaEditDialogComponent
  ],
  entryComponents: [
    UserAddDialogComponent,
    UserEditDialogComponent,
    IdeaAddDialogComponent,
    IdeaEditDialogComponent
  ],
  providers: [
    UserService,
    IdeaService
  ]
})

export class AdminModule { }
