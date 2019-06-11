import { Component, OnInit, ViewChild, ChangeDetectorRef } from '@angular/core';
import { Router } from '@angular/router';

import {
  MatSort,
  MatTableDataSource,
  MatDialog } from '@angular/material';

import { UserAddDialogComponent } from './user-add-dialog/user-add-dialog.component';
import { UserEditDialogComponent } from './user-edit-dialog/user-edit-dialog.component';
import { User } from '../../model/user';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'bi-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {

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
        dialogRef = this.dialog.open(UserEditDialogComponent, {
          width: '270px',
          data: user
      });

    } else {
        console.log('opening Add User');
        dialogRef = this.dialog.open(UserAddDialogComponent, {
          width: '270px',
          data: new User
      });
    }

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed, result: ' + result);
      this.refresh();
      this.user = undefined;
    });
  }
}

