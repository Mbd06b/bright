import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { ActivatedRoute } from '@angular/router';

import { UserService } from '../service/user.service';
import { IdeaService } from '../service/idea.service';
import { User } from '../model/user';
import { Breakpoints, BreakpointState, BreakpointObserver } from '@angular/cdk/layout';
import { IdeaLinkView } from '../model/idealinkview';

@Component({
  selector: 'bi-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  id: number;
  private subscribe: any;
  user: User;
  ideaTiles: IdeaLinkView [];





   /** Based on the screen size, switch from standard to one column per row */
   cards = this.breakpointObserver.observe(Breakpoints.Handset).pipe(
    map(({ matches }) => {

      if (matches) {
        return [
          { title: 'Card 1', cols: 1, rows: 1 },
          { title: 'Card 2', cols: 1, rows: 1 },
          { title: 'Card 3', cols: 1, rows: 1 },
          { title: 'Card 4', cols: 1, rows: 1 }
        ];
      } else {
        return [
          { title: 'Card 1', cols: 2, rows: 1 },
          { title: 'Card 2', cols: 1, rows: 1 },
          { title: 'Card 3', cols: 1, rows: 2 },
          { title: 'Card 4', cols: 1, rows: 1 }
        ];
      }
    })
  );

  tiles = [
    {text: 'One', cols: 2, rows: 1, color: 'lightblue'},
    {text: 'Two', cols: 1, rows: 2, color: 'lightgreen'},
    {text: 'Three', cols: 1, rows: 1, color: 'lightpink'},
    {text: 'Four', cols: 2, rows: 1, color: '#DDBDF1'},
  ];

  folders = [
    { name: 'Photos', updated: new Date('1/1/16'), },
    { name: 'Recipes', updated: new Date('1/17/16'), },
    { name: 'Work', updated: new Date('1/28/16'), }
  ];

  notes = [
    { name: 'Vacation Itinerary', updated: new Date('2/20/16'),},
    { name: 'Kitchen Remodel', updated: new Date('1/18/16'), }
  ];

  constructor(
    private route: ActivatedRoute,
    private userService: UserService,
    private ideaService: IdeaService,
    private breakpointObserver: BreakpointObserver
  ) { }

  ngOnInit() {
    this.subscribe = this.route.params.subscribe(params => {
      this.id = +params['id'];
    });

    this.userService.getUserById(this.id).subscribe(
      (data) => {
        this.user = data;
    });

    this.ideaService.getIdeasByUserId(this.id).subscribe(
      (data) => {
        this.user.ideas = data;
      });

    //this.ideaTiles = this.user.ideas;
  }

}
