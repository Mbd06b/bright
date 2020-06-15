import { Component, OnInit, AfterViewInit } from '@angular/core';
import { AuthenticationService } from '../core/service/authentication.service';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.scss']
})
export class LandingComponent implements OnInit {


  placeholderImgSrc = 'https://placehold.it/150x80?text=IMAGE';

  ideaHighlights = [
    { featuredImgUrl: this.placeholderImgSrc, title: 'Live Plants for the Breakroom' },
    { featuredImgUrl: this.placeholderImgSrc, title: 'Fix an Outlet' },
    { featuredImgUrl: this.placeholderImgSrc, title: 'Add Banking Services to USPS' },
    { featuredImgUrl: this.placeholderImgSrc, title: 'Build an Opensource Skills Database App' },
    { featuredImgUrl: this.placeholderImgSrc, title: 'Recreate the Titanic in Ureal 5' },
    { featuredImgUrl: this.placeholderImgSrc, title: 'Install a Local WiFi' },
    { featuredImgUrl: this.placeholderImgSrc, title: 'Build a Street Sign' },
    { featuredImgUrl: this.placeholderImgSrc, title: 'Host a Class on Technology' },


  ];

  // TODO set global static final configuration variables for title;
  title = 'BrightIdeas';

  constructor(
    public authService: AuthenticationService
   ) { }



ngOnInit() {}

}
