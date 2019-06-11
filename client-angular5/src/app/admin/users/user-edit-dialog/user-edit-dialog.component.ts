import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { User } from '../../../model/user';
import { UserService } from '../../../service/user.service';
import { Role } from '../../../model/role.enum';




@Component({
  selector: 'bi-user-edit-dialog',
  templateUrl: './user-edit-dialog.component.html',
  styleUrls: ['./user-edit-dialog.component.scss'],
})
export class UserEditDialogComponent implements OnInit {

  options: string[];
  user: User;
  returnedUser: User;

  // TODO move hard-coded object to an enum Model
  rolesArray: string [] = [ 'NONE', 'USER', 'MODERATOR', 'ADMIN'];

  constructor(
    private userService: UserService,
    public dialogRef: MatDialogRef<UserEditDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: User) {
      console.log(data);
      this.user = data;
    }

  submitForm(user): void {
      console.log('Submitting User..');
      console.log(user);
      this.userService.updateUser(user)
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
