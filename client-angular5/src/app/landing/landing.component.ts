import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'bi-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.scss']
})
export class LandingComponent implements OnInit {

  // TODO set global static final configuration variables for title;
  title = 'BrightIdeas';

  constructor(
    public authService: AuthService
   ) { }

  ngOnInit() {
  }

}
