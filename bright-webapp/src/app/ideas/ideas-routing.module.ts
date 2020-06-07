import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IdeasGridComponent } from './ideas-grid/ideas-grid.component';
import { IdeasNavigationComponent } from './ideas-navigation/ideas-navigation.component';
import { IdeasListComponent } from './ideas-list/ideas-list.component';
import { IdeasComponent } from './ideas.component';


const routes: Routes = [
  { path: '', outlet: 'leftNav', component: IdeasNavigationComponent },
  { path: '', component: IdeasComponent,
      children: [
        { path: 'all', component: IdeasListComponent },
        { path: 'other', component: IdeasGridComponent }
      ]
  },
  { path: ':id', loadChildren: () => import ('../idea/idea.module').then(m => m.IdeaModule) },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class IdeasRoutingModule { }
