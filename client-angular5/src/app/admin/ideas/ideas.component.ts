import { Component, OnInit, ViewChild, ChangeDetectorRef } from '@angular/core';
import { Router } from '@angular/router';

import {
  MatSort,
  MatTableDataSource,
  MatDialog } from '@angular/material';

import { IdeaAddDialogComponent } from './idea-add-dialog/idea-add-dialog.component';
import { IdeaEditDialogComponent } from './idea-edit-dialog/idea-edit-dialog.component';
import { Idea } from '../../model/idea';
import { IdeaService } from '../../service/idea.service';

@Component({
  selector: 'bi-ideas',
  templateUrl: './ideas.component.html',
  styleUrls: ['./ideas.component.scss']
})
export class IdeasComponent implements OnInit {

  displayedColumns = ['id', 'title', 'subtitle', 'edit', 'more-menu'];
  idea: Idea;
  dataSource: MatTableDataSource<Idea>;
  ideas: Idea[] = [];

  @ViewChild(MatSort) sort: MatSort;

  constructor(
    private changeDetectorRefs: ChangeDetectorRef,
    private ideaService: IdeaService,
    private router: Router,
    public dialog: MatDialog) {
  }

  ngOnInit() {
    this.ideaService.getIdeas()
      .subscribe(
        (data) => {this.ideas = data;
        this.dataSource = new MatTableDataSource(this.ideas);
        this.dataSource.sort = this.sort;
      });
    this.refresh();
  }

  navigateTo(row: any) {
    this.router.navigate(['/home/ideas/' + row.id]);
  }

  deleteIdea(id: number) {
     this.ideaService.deleteIdea(id).subscribe( result => {
      console.log('deleteIdea result...');
      console.log(result);
      this.refresh();
     });
  }

  refresh() {
     this.ideaService.getIdeas()
      .subscribe(
        (data) => {this.ideas = data;
        this.dataSource = new MatTableDataSource(this.ideas);
        this.changeDetectorRefs.detectChanges();
      });
    }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // Datasource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }


  openDialog(idea: Idea): void {
    let dialogRef;
    if (idea !== undefined) {
        console.log('opening Edit Idea');
        dialogRef = this.dialog.open(IdeaEditDialogComponent, {
          width: '270px',
          data: idea
      });

    } else {
        console.log('opening Add Idea');
        dialogRef = this.dialog.open(IdeaAddDialogComponent, {
          width: '270px',
          data: new Idea
      });
    }

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed, result: ' + result);
      this.refresh();
      this.idea = undefined;
    });
  }
}

