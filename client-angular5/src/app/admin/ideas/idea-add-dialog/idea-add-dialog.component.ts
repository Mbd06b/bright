import { Component, OnInit, Inject } from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Idea } from '../../../model/idea';
import { IdeaService } from '../../../service/idea.service';


@Component({
  selector: 'bi-idea-add-dialog',
  templateUrl: './idea-add-dialog.component.html',
  styleUrls: ['./idea-add-dialog.component.scss'],
  providers: [
    { provide: MAT_DIALOG_DATA, useValue: {} }
  ],
})
export class IdeaAddDialogComponent implements OnInit {

  idea: Idea;
  returnedIdea: Idea;

  constructor(
    private ideaService: IdeaService,
    public dialogRef: MatDialogRef<IdeaAddDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Idea) {
      this.idea = data;
    }

  submitForm(idea: Idea): void {
    console.log(idea);
      this.ideaService.postIdea(idea)
        .subscribe(
          (data) => {this.returnedIdea = data;
          });
    this.dialogRef.close();
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
  }

}
