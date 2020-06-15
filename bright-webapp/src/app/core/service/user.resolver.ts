import { Injectable } from '@angular/core';
import { UserService } from './user.service';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, RouterModule } from '@angular/router';
import { Observable } from 'rxjs/internal/Observable';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserResolver implements Resolve<User> {

  constructor(
    private userService: UserService
  ) { }

  resolve( route: ActivatedRouteSnapshot ): Observable<User> {
    const id = +route.paramMap.get('id');
    return this.userService.getUserById(id);
  }
}
