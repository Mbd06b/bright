import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IdeaEditDialogueComponent } from '../ideas/idea-edit-dialogue/idea-edit-dialogue.component';
import { IdeaComponent } from './idea.component';


const routes: Routes = [
 { path: '',  component: IdeaComponent,
      children: [
        { path: 'edit', component: IdeaEditDialogueComponent },

      ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class IdeaRoutingModule { }
