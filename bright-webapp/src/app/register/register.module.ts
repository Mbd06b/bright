import { RegisterComponent } from './register.component';
import { NgModule } from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { RegisterRoutingModule } from './register-routing.module';


@NgModule({
  imports: [
    SharedModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    FormsModule,
    RegisterRoutingModule
  ],
  declarations: [
    RegisterComponent
  ],
  exports: [],
})
export class RegisterModule {}
