import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/core/service/authentication.service';
import { User } from 'src/app/core/model/user';

@Component({
  selector: 'app-ideas-navigation',
  templateUrl: './ideas-navigation.component.html',
  styleUrls: ['./ideas-navigation.component.scss']
})
export class IdeasNavigationComponent implements OnInit {

  constructor(
    private authService: AuthenticationService
  ) { }

  currentUser: User;

  ngOnInit(): void {
    this.currentUser = this.authService.currentUser;
  }

}
