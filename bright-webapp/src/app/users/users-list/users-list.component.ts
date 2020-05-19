import { Component, OnInit, ViewChild, ChangeDetectorRef } from '@angular/core';
import { User } from 'src/app/core/model/user';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { UserService } from 'src/app/core/service/user.service';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { UserAddDialogueComponent } from '../user-add-dialogue/user-add-dialogue.component';
import { UserEditDialogueComponent } from '../user-edit-dialogue/user-edit-dialogue.component';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.scss']
})
export class UsersListComponent implements OnInit {
  displayedColumns = ['id', 'name', 'email', 'role', 'edit', 'more-menu'];
  user: User;
  dataSource: MatTableDataSource<User>;
  users: User[] = [];

  @ViewChild(MatSort) sort: MatSort;

  constructor(
    private changeDetectorRefs: ChangeDetectorRef,
    private userService: UserService,
    private router: Router,
    public dialog: MatDialog) {

  }

  ngOnInit() {
    this.userService.getUsers()
    .subscribe(
      (data) => {this.users = data;
                 this.dataSource = new MatTableDataSource(this.users);
                 this.dataSource.sort = this.sort;
    });
    this.refresh();
  }

  navigateTo(row: any) {
    this.router.navigate(['/home/people/' + row.id]);
  }

  deleteUser(id: number) {
     this.userService.deleteUser(id).subscribe( result => {
      console.log('deleteUser result...');
      console.log(result);
      this.refresh();
     });
  }

  refresh() {
     this.userService.getUsers()
      .subscribe(
        (data) => {this.users = data;
                   this.dataSource = new MatTableDataSource(this.users);
                   this.changeDetectorRefs.detectChanges();
      });
    }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // Datasource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }


  openDialog(user: User): void {
    let dialogRef;
    if (user !== undefined) {
        console.log('opening Edit User');
        dialogRef = this.dialog.open(UserEditDialogueComponent, {
          width: '270px',
          data: user
      });

    } else {
        console.log('opening Add User');
        dialogRef = this.dialog.open(UserAddDialogueComponent, {
          width: '270px',
          data: new User()
      });
    }

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed, result: ' + result);
      this.refresh();
      this.user = undefined;
    });
  }
}
