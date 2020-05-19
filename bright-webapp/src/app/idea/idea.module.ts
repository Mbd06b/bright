import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { IdeaRoutingModule } from './idea-routing.module';
import { IdeaComponent } from './idea.component';


@NgModule({
  declarations: [IdeaComponent],
  imports: [
    CommonModule,
    IdeaRoutingModule
  ]
})
export class IdeaModule { }
