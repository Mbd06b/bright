import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserIdeasRoutingModule } from './user-ideas-routing.module';
import { UserIdeasComponent } from './user-ideas.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatListModule } from '@angular/material/list';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { MatButtonToggleModule } from '@angular/material/button-toggle';


@NgModule({
  declarations: [UserIdeasComponent],
  imports: [
    CommonModule,
    UserIdeasRoutingModule,
    MatToolbarModule,
    MatListModule,
    MatGridListModule,
    MatCardModule,
    MatIconModule,
    MatMenuModule,
    MatButtonModule,
    MatButtonToggleModule
  ]
})
export class UserIdeasModule { }
