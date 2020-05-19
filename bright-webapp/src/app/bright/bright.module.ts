import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BrightRoutingModule } from './bright-routing.module';
import { BrightComponent } from './bright.component';
import { SharedModule } from '../shared/shared.module';
import { NavigationComponent } from './navigation/navigation.component';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';


@NgModule({
  declarations: [NavigationComponent, BrightComponent],
  imports: [
    CommonModule,
    SharedModule,
    BrightRoutingModule,
    MatSidenavModule,
    MatToolbarModule,
    MatButtonModule,
    MatMenuModule,
    MatIconModule,
    MatListModule
  ]
})
export class BrightModule { }
