import { Component, OnInit } from '@angular/core';
import { Idea } from '../core/model/idea';
import { ActivatedRoute } from '@angular/router';
import { IdeaService } from '../core/service/idea.service';

@Component({
  selector: 'app-idea',
  templateUrl: './idea.component.html',
  styleUrls: ['./idea.component.scss']
})
export class IdeaComponent implements OnInit {

  id: number;
  private subscribe: any;
  idea: Idea;

  constructor(
    private route: ActivatedRoute,
    private ideaService: IdeaService
  ) { }

  ngOnInit(): void {
    this.subscribe = this.route.params.subscribe(params => {
      this.id = +params.id;
    });

    this.ideaService.getIdeaById(this.id).subscribe(
      (data) => {
        this.idea = data;
      });
  }

}
