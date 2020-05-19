import { Component, OnInit, Inject } from '@angular/core';
import { Idea } from 'src/app/core/model/idea';
import { IdeaService } from 'src/app/core/service/idea.service';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-idea-edit-dialogue',
  templateUrl: './idea-edit-dialogue.component.html',
  styleUrls: ['./idea-edit-dialogue.component.scss'],
  providers: [
    { provide: MAT_DIALOG_DATA, useValue: {} }
  ],
})
export class IdeaEditDialogueComponent implements OnInit {

  idea: Idea;
  returnedIdea: Idea;

  constructor(
    private ideaService: IdeaService,
    public dialogRef: MatDialogRef<IdeaEditDialogueComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Idea) {
      console.log(data);
      this.idea = data;
    }

  submitForm(idea): void {
      this.ideaService.updateIdea(idea)
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
