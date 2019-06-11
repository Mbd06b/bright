import { Component, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs/Observable';
import { map } from 'rxjs/operators';

import { AuthService } from '../service/auth.service';
import { User } from '../model/user';

@Component({
  selector: 'bi-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {

  currentUser: User = null;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
    );
  constructor(
    private breakpointObserver: BreakpointObserver,
    public authService: AuthService) { }

  ngOnInit() {
    this.currentUser = this.authService.currentUser;
  }

}
