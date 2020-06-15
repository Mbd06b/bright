import { Component } from '@angular/core';
import { AuthenticationService } from './core/service/authentication.service';
import { Router, Event, NavigationStart, NavigationEnd, NavigationCancel, NavigationError } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  isLoading = true;
  title = 'bright-webapp';

  constructor(
    private authService: AuthenticationService,
    private router: Router
   ) {
     this.router.events.subscribe( (routerEvent: Event ) => {
        this.checkRoutingEvent(routerEvent);
     });
     }

  checkRoutingEvent(routerEvent: Event) {
    if (routerEvent  instanceof NavigationStart ) {
      this.isLoading = true;
    }
    if (routerEvent instanceof NavigationEnd ||
        routerEvent instanceof NavigationCancel ||
        routerEvent instanceof NavigationError ) {
          this.isLoading = false;
    }
  }

}
