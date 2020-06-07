import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserIdeasComponent } from './user-ideas.component';


const routes: Routes = [
  { path: '', component: UserIdeasComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserIdeasRoutingModule { }
