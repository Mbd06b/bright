import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminDashboardRoutingModule } from './admin-dashboard-routing.module';
import { AdminDashboardComponent } from './admin-dashboard.component';
import { MatCardModule } from '@angular/material/card';
import { MatTabsModule } from '@angular/material/tabs';
import { IdeasModule } from '../ideas/ideas.module';
import { UsersModule } from '../users/users.module';


@NgModule({
  declarations: [AdminDashboardComponent],
  imports: [
    CommonModule,
    AdminDashboardRoutingModule,
    MatCardModule,
    MatTabsModule,
    IdeasModule,
    UsersModule
  ]
})
export class AdminDashboardModule { }
