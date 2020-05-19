import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { IdeasRoutingModule } from './ideas-routing.module';
import { IdeasComponent } from './ideas.component';
import { IdeasListComponent } from './ideas-list/ideas-list.component';
import { IdeasCardComponent } from './ideas-card/ideas-card.component';
import { IdeasGridComponent } from './ideas-grid/ideas-grid.component';
import { IdeaAddDialogueComponent } from './idea-add-dialogue/idea-add-dialogue.component';
import { SharedModule } from '../shared/shared.module';
import { MatCardModule } from '@angular/material/card';
import { MatTabsModule } from '@angular/material/tabs';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatOptionModule } from '@angular/material/core';
import { MatButtonModule } from '@angular/material/button';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatDialogModule} from '@angular/material/dialog';
import {MatSelectModule} from '@angular/material/select';
import { IdeaEditDialogueComponent } from './idea-edit-dialogue/idea-edit-dialogue.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    IdeasComponent,
    IdeasListComponent,
    IdeasCardComponent,
    IdeasGridComponent,
    IdeaAddDialogueComponent,
    IdeaEditDialogueComponent
  ],
  imports: [
    CommonModule,
    IdeasRoutingModule,
    FormsModule, //TODO convert to ReactiveFormsModule (in SharedModule )
    SharedModule,
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
  ]
})
export class IdeasModule { }
