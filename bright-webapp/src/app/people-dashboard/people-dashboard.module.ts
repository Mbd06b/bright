import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PeopleDashboardRoutingModule } from './people-dashboard-routing.module';
import { PeopleDashboardComponent } from './people-dashboard.component';


@NgModule({
  declarations: [PeopleDashboardComponent],
  imports: [
    CommonModule,
    PeopleDashboardRoutingModule
  ]
})
export class PeopleDashboardModule { }
