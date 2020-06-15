import { Component, OnInit, Input } from '@angular/core';
import { IdeaLinkView } from 'src/app/core/model/idealinkview';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { map } from 'rxjs/operators';
import { User } from 'src/app/core/model/user';
import { IdeaService } from 'src/app/core/service/idea.service';
import { Idea } from 'src/app/core/model/idea';
import { UserService } from 'src/app/core/service/user.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-ideas',
  templateUrl: './user-ideas.component.html',
  styleUrls: ['./user-ideas.component.scss']
})
export class UserIdeasComponent implements OnInit {

  ideas: Idea [];
  id: number;
  private subscribe: any;
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
    private breakpointObserver: BreakpointObserver,
    private route: ActivatedRoute,
    private ideaService: IdeaService
  ) { }

  ngOnInit(): void {

    this.subscribe = this.route.params.subscribe(params => {
      this.id = +params.id;
    });

    this.ideaService.getIdeasByUserId(this.id).subscribe(
      (data) => {
        this.ideas = data;
      });

  }



}
