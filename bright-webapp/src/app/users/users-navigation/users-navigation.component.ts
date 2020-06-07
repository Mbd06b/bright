import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/core/model/user';
import { AuthenticationService } from 'src/app/core/service/authentication.service';

@Component({
  selector: 'app-users-navigation',
  templateUrl: './users-navigation.component.html',
  styleUrls: ['./users-navigation.component.scss']
})
export class UsersNavigationComponent implements OnInit {

  constructor(
    private authService: AuthenticationService
   ) { }

   currentUser: User;

  ngOnInit(): void {
    this.currentUser = this.authService.currentUser;
  }

}
