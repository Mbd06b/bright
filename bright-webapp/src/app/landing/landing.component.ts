import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../core/service/authentication.service';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.scss']
})
export class LandingComponent implements OnInit {

  // TODO set global static final configuration variables for title;
  title = 'BrightIdeas';

  constructor(
    public authService: AuthenticationService
   ) { }

  ngOnInit() {
  }

}
