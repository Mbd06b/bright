import { Component, OnInit, ViewChild } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { map, filter, startWith, tap } from 'rxjs/operators';
import { Observable } from 'rxjs/internal/Observable';
import { User } from 'src/app/core/model/user';
import { AuthenticationService } from 'src/app/core/service/authentication.service';
import { MatSidenav } from '@angular/material/sidenav';
import { ActivatedRoute, Router, NavigationEnd, NavigationStart, RouterEvent } from '@angular/router';



@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent implements OnInit {


  constructor(
    private breakpointObserver: BreakpointObserver,
    private authService: AuthenticationService,
    private router: Router) {
      router.events.pipe(
        filter( event => event instanceof NavigationStart),
        startWith(null), // Start with something, because the app doesn't fire this on appload, only on subsequent route changes
        tap(event => {
           console.log(event);
        }/* Place code to track NavigationStart here */),
    ).subscribe();
    }


  @ViewChild(MatSidenav) sidenav: MatSidenav;

  currentUser: User;
  isAuthenticated: boolean;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
    );

  ngOnInit(): void {
    this.currentUser = this.authService.currentUser;
    this.isAuthenticated = this.authService.isAuthenticated;
  }



logout() {
    this.authService.logout();
  }


}
