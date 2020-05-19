


// designed pattern referenced, https://dzone.com/articles/angular-5-material-design-login-application
// see, auth.service.ts

import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { User } from '../core/model/user';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from '../core/service/authentication.service';
import { UserService } from '../core/service/user.service';
import { AuthRequest } from '../core/model/authRequest';
import { first } from 'rxjs/operators';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})

export class RegisterComponent implements OnInit {
    registrationForm: FormGroup;
    isAuthenticated: boolean;
    loading = false;
    confirmPassword: string;
    submitted = false;
    returnUrl: string;
    user: User;

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authService: AuthenticationService,
        private userService: UserService
        ) {}

    ngOnInit() {
        this.isAuthenticated = this.authService.isAuthenticated;
        this.registrationForm = this.formBuilder.group({

            firstName: ['', Validators.required],
            lastName:['', Validators.required],
            email: ['', Validators.required],
            password: ['', Validators.required],
            confirmPassword: ['', Validators.required]
        });

        // reset login status
       // this.authenticationService.logout();

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/home/people/';
        this.user = new User();
    }

    // convenience getter for easy access to form fields
    get f() { return this.registrationForm.controls; }

    onSubmit() {
        this.submitted = true;
        this.user.email = this.f.email.value;
        this.user.password = this.f.password.value;
        this.confirmPassword = this.f.confirmPassword.value;
        this.user.firstName = this.f.firstName.value;
        this.user.lastName = this.f.lastName.value;

        // stop here if form is invalid
        if (this.registrationForm.invalid) {
            return;
        }
        let authRequest: AuthRequest = new AuthRequest();
        authRequest.key = this.user.email;
        authRequest.password = this.user.password;

        this.loading = true;

        // post the user
        this.userService.postUser(this.user)
          .subscribe(() => {

            // get the new user id for login redirect
            this.userService.getUserByEmail(this.user.email)
            .subscribe((data: User) => {
              this.user.id = data.id;
              console.log('postUser completes for new User[' + this.user.id + ']');
                // login user and redirect to profile page
                this.authService.login(authRequest)
                .pipe(first())
                .subscribe(
                    data => {
                        this.router.navigate([this.returnUrl + this.user.id]);
                    },
                    error => {
                         this.loading = false;
                    });
            });
          });
    }

    logout() {
      this.authService.logout();
    }
}
