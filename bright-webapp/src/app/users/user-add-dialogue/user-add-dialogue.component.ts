import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { User } from 'src/app/core/model/user';
import { UserService } from 'src/app/core/service/user.service';

@Component({
  selector: 'app-user-add-dialogue',
  templateUrl: './user-add-dialogue.component.html',
  styleUrls: ['./user-add-dialogue.component.scss'],
  providers: [
    { provide: MAT_DIALOG_DATA, useValue: {} }
  ]
})
export class UserAddDialogueComponent implements OnInit {
  user: User;
  returnedUser: User;

  constructor(
    private userService: UserService,
    public dialogRef: MatDialogRef<UserAddDialogueComponent>,
    @Inject(MAT_DIALOG_DATA) public data: User) {
      this.user = data;
    }

  submitForm(user: User): void {
      this.userService.postUser(user)
        .subscribe(
          (data) => {this.returnedUser = data;
          });
      this.dialogRef.close();
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
  }

}
