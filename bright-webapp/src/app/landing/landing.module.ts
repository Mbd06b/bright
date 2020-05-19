import { NgModule } from '@angular/core';

import { SharedModule } from '../shared/shared.module';
import { LandingComponent } from './landing.component';
import { MatCardModule } from '@angular/material/card';
import { MatTabsModule } from '@angular/material/tabs';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LandingRoutingModule } from './landing-routing.module';

@NgModule({
  imports: [
    SharedModule,
    LandingRoutingModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    MatTabsModule,
    FormsModule,
  ],
  declarations: [LandingComponent],
  exports: [],
})
export class LandingModule {}
