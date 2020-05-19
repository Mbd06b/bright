import { NgModule } from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { LoginComponent } from './login.component';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { LoginRoutingModule } from './login-routing.module';


@NgModule({
  imports: [
    LoginRoutingModule,
    CommonModule,
    RouterModule,
    SharedModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    FormsModule,
  ],
  declarations: [
    LoginComponent
  ],
  exports: [],
})
export class LoginModule {}
