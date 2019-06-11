import { Injectable } from '@angular/core';
import { UserService } from './user.service';
import { AuthService } from './auth.service';

// Validation Service design pattern referenced
// https://coryrylan.com/blog/angular-form-builder-and-validation-management


@Injectable()
export class ValidationService {

  constructor(
    private userService: UserService,
    private authService: AuthService,
  ) { }

  exists: Boolean = false;



  static getValidatorErrorMessage(validatorName: string, validatorValue?: any) {
      let config = {
          'required': 'Required',
          'invalidEmailAddress': 'Invalid email address',
          'invalidPassword': 'Invalid password. Password must be at least 6 characters long, and contain a number.',
          'unknownEmailAddress': 'Could not find your account',
          'wrongPassword' : 'Wrong password. Try again or click Forgot password to reset it.',
          'minlength': `Minimum length ${validatorValue.requiredLength}`,
      };

      return config[validatorName];
  }

  static emailValidator(control) {
      // RFC 2822 compliant regex
      // tslint:disable-next-line:max-line-length
      if (control.value.match(/[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/)) {
          return null;
      } else {
          return { 'invalidEmailAddress': true };
      }
  }

  static passwordValidator(control) {
      // {6,100}           - Assert password is between 6 and 100 characters
      // (?=.*[0-9])       - Assert a string has at least one number
      if (control.value.match(/^(?=.*[0-9])[a-zA-Z0-9!@#$%^&*]{6,100}$/)) {
          return null;
      } else {
          return { 'invalidPassword': true };
      }
  }


  emailAccountValidator(control){

    if(this.emailExists(control)){
    return null;
    } else {
      return { 'unknownEmailAddress': true};
    }

  }

  emailExists(email) {
    return this.userService.existsByEmail(email).subscribe(
      (data) => {this.exists = data;
      });
  }
}
