import { Component } from '@angular/core';

@Component({
  selector: 'bi-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent {
  title = 'BrightIdeas5';

  public appState = {
    loggedIn: true
  };
}
