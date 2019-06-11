import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { Idea } from '../../../model/idea';
import { IdeaService } from '../../../service/idea.service';




@Component({
  selector: 'bi-idea-edit-dialog',
  templateUrl: './idea-edit-dialog.component.html',
  styleUrls: ['./idea-edit-dialog.component.scss'],
})
export class IdeaEditDialogComponent implements OnInit {

  idea: Idea;
  returnedIdea: Idea;

  constructor(
    private ideaService: IdeaService,
    public dialogRef: MatDialogRef<IdeaEditDialogComponent>,
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
