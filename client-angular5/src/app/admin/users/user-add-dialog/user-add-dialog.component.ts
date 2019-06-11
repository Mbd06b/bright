import { Component, OnInit, Inject } from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { User } from '../../../model/user';
import { UserService } from '../../../service/user.service';


@Component({
  selector: 'bi-user-add-dialog',
  templateUrl: './user-add-dialog.component.html',
  styleUrls: ['./user-add-dialog.component.scss'],
  providers: [
    { provide: MAT_DIALOG_DATA, useValue: {} }
  ],
})
export class UserAddDialogComponent implements OnInit {

  user: User;
  returnedUser: User;

  constructor(
    private userService: UserService,
    public dialogRef: MatDialogRef<UserAddDialogComponent>,
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
