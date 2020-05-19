import { Component, OnInit, Inject } from '@angular/core';
import { Idea } from 'src/app/core/model/idea';
import { IdeaService } from 'src/app/core/service/idea.service';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-idea-add-dialogue',
  templateUrl: './idea-add-dialogue.component.html',
  styleUrls: ['./idea-add-dialogue.component.scss'],
  providers: [
    { provide: MAT_DIALOG_DATA, useValue: {} }
  ]
})
export class IdeaAddDialogueComponent implements OnInit {


  idea: Idea;
  returnedIdea: Idea;

  constructor(
    private ideaService: IdeaService,
    public dialogRef: MatDialogRef<IdeaAddDialogueComponent>,
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
