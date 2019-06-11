import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IdeaService } from '../service/idea.service';
import { Idea } from '../model/idea';


@Component({
  selector: 'bi-idea-detail',
  templateUrl: './idea-detail.component.html',
  styleUrls: ['./idea-detail.component.scss']
})
export class IdeaDetailComponent implements OnInit {

  id: number;
  private subscribe: any;
  idea: Idea;

  constructor(
    private route: ActivatedRoute,
    private ideaService: IdeaService
  ) { }

  ngOnInit() {
    this.subscribe = this.route.params.subscribe(params => {
      this.id = +params['id'];
    });

    this.ideaService.getIdeaById(this.id).subscribe(
      (data) => {
        this.idea = data;
      });
  }

}
