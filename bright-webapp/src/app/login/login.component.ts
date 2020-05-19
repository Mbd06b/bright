import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { first } from 'rxjs/operators';

import { AuthenticationService } from '../core/service/authentication.service';
import { User } from '../core/model/user';
import { AlertService } from '../core/service/alert.service';
import { AuthRequest } from '../core/model/authRequest';
import { from } from 'rxjs';

// designed pattern referenced, https://dzone.com/articles/angular-5-material-design-login-application
// see, auth.service.ts

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  isAuthenticated: boolean;
  loginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  user: User;

  constructor(
      private formBuilder: FormBuilder,
      private route: ActivatedRoute,
      private router: Router,
      public authService: AuthenticationService,
      private alertService: AlertService
    ) {}

  ngOnInit() {
      this.isAuthenticated = this.authService.isAuthenticated;
      this.loginForm = this.formBuilder.group({
          email: ['', Validators.required],
          password: ['', Validators.required]
      });


      // get return url from route parameters or default to '/'
      this.returnUrl = this.route.snapshot.queryParams.returnUrl || '/bright';
      this.user = new User();
  }

  // convenience getter for easy access to form fields
  get f() { return this.loginForm.controls; }

  onSubmit() {
      const authRequest: AuthRequest = new AuthRequest();
      this.submitted = true;
      authRequest.key = this.f.email.value;
      authRequest.password = this.f.password.value;
      // stop here if form is invalid
      if (this.loginForm.invalid) {
          return;
      }

      this.loading = true;
      this.authService.login(authRequest)
          .pipe(first())
          .subscribe(
              data => {
                  this.router.navigate([this.returnUrl]);
              },
              error => {
                  this.alertService.error(error);
                  this.loading = false;
              });
  }

  logout() {
    this.authService.logout();
  }
}
