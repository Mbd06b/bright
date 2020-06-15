import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from '../core/model/user';
import { IdeaLinkView } from '../core/model/idealinkview';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { map } from 'rxjs/operators';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../core/service/user.service';
import { IdeaService } from '../core/service/idea.service';
import { UserBannerComponent } from './user-banner/user-banner.component';
import { UserActivityComponent } from './user-activity/user-activity.component';
import { UserDetailComponent } from './user-detail/user-detail.component';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  @ViewChild(UserBannerComponent) banner;

  id: number;
  user: User;
  navLinks: any[];
  activeLinkIndex = 0;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService,
    private ideaService: IdeaService,
    private breakpointObserver: BreakpointObserver
  ) {
    this.user = route.snapshot.data.user;
    this.id = this.user.id;
    this.navLinks = [
      {
        label: 'Activity',
        path: './',
        index: 0,
      },
      {
        label: 'About',
        path: 'about',
        index: 1,
      },
    ];
   }

  ngOnInit(): void {
    this.route.data.subscribe( data => {
      const resolvedUser: User = data.user;
      this.onUserRetrieved(resolvedUser);
    });
    this.router.events.subscribe((res) => {
      this.activeLinkIndex = this.navLinks.indexOf(
        this.navLinks.find((tab) => tab.link === '.' + this.router.url)
      );
    });
  }

  onUserRetrieved(user: User): void {
    this.user = user;
  }




}
