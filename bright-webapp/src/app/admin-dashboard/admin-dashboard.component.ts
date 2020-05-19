import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.scss'],
})
export class AdminDashboardComponent implements OnInit {
  navLinks: any[];
  activeLinkIndex = 0;

  constructor(private router: Router) {
    this.navLinks = [
      {
        label: 'Users',
        path: 'users',
        index: 0,
      },
      {
        label: 'Ideas',
        path: 'ideas',
        index: 1,
      },
    ];
  }

  ngOnInit(): void {
    this.router.events.subscribe((res) => {
      this.activeLinkIndex = this.navLinks.indexOf(
        this.navLinks.find((tab) => tab.link === '.' + this.router.url)
      );
    });
  }
}
