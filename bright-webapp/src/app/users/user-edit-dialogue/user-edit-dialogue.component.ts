import { Component, OnInit, Inject } from '@angular/core';
import { User } from 'src/app/core/model/user';
import { UserService } from 'src/app/core/service/user.service';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-user-edit-dialogue',
  templateUrl: './user-edit-dialogue.component.html',
  styleUrls: ['./user-edit-dialogue.component.scss']
})
export class UserEditDialogueComponent implements OnInit {
  ptions: string[];
  user: User;
  returnedUser: User;

  // TODO move hard-coded object to an enum Model
  rolesArray: string [] = [ 'NONE', 'USER', 'MODERATOR', 'ADMIN'];

  constructor(
    private userService: UserService,
    public dialogRef: MatDialogRef<UserEditDialogueComponent>,
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
