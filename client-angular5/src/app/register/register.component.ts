import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { first } from 'rxjs/operators';
import { AuthService } from '../service/auth.service';
import { AlertService } from '../service/alert.service';
import { User } from '../model/user';
import { UserService } from '../service/user.service';
import { a } from '@angular/core/src/render3';


// designed pattern referenced, https://dzone.com/articles/angular-5-material-design-login-application
// see, auth.service.ts


@Component({
  selector: 'bi-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})

export class RegisterComponent implements OnInit {
    registrationForm: FormGroup;
    loading = false;
    confirmPassword: string;
    submitted = false;
    returnUrl: string;
    user: User;

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authService: AuthService,
        private alertService: AlertService,
        private userService: UserService) {}

    ngOnInit() {
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
                this.authService.login(this.user)
                .pipe(first())
                .subscribe(
                    data => {
                        this.router.navigate([this.returnUrl + this.user.id]);
                    },
                    error => {
                        this.alertService.error(error);
                        this.loading = false;
                    });
            });
          });
    }

    logout() {
      this.authService.logout();
    }
}
