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
import { MatGridListModule } from '@angular/material/grid-list';
import { MatTabsModule } from '@angular/material/tabs';
import { MatChipsModule } from '@angular/material/chips';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatOptionModule } from '@angular/material/core';
import { MatButtonModule } from '@angular/material/button';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatDialogModule } from '@angular/material/dialog';
import { MatSelectModule } from '@angular/material/select';
import { IdeaEditDialogueComponent } from './idea-edit-dialogue/idea-edit-dialogue.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { IdeaFilterComponent } from './idea-filter/idea-filter.component';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import { IdeasNavigationComponent } from './ideas-navigation/ideas-navigation.component';
import { MatListModule } from '@angular/material/list';




@NgModule({
  declarations: [
    IdeasComponent,
    IdeasListComponent,
    IdeasCardComponent,
    IdeasGridComponent,
    IdeaAddDialogueComponent,
    IdeaEditDialogueComponent,
    IdeaFilterComponent,
    IdeasNavigationComponent
  ],
  imports: [
    CommonModule,
    IdeasRoutingModule,
    FormsModule, //TODO convert to ReactiveFormsModule (in SharedModule )
    ReactiveFormsModule,
    SharedModule,
    MatCardModule,
    MatGridListModule,
    MatListModule,
    MatAutocompleteModule,
    MatTabsModule,
    MatChipsModule,
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
