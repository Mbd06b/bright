import { Component } from '@angular/core';
import { AuthenticationService } from './core/service/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'bright-webapp';
  constructor(
    public authService: AuthenticationService
   ) { }
}
