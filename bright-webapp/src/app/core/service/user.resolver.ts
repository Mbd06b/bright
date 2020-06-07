import { Injectable } from '@angular/core';
import { UserService } from './user.service';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs/internal/Observable';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserResolver implements Resolve<User> {

  constructor(
    private userService: UserService
  ) { }

  resolve(): Observable<User> {
    return this.userService.getUserByToken(localStorage.getItem('token'));
  }
}
