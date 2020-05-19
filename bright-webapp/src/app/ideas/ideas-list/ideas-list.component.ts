import { Component, OnInit, ViewChild, ChangeDetectorRef } from '@angular/core';
import { Idea } from 'src/app/core/model/idea';
import { IdeaService } from 'src/app/core/service/idea.service';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { MatDialog } from '@angular/material/dialog';
import { IdeaEditDialogueComponent } from '../idea-edit-dialogue/idea-edit-dialogue.component';
import { IdeaAddDialogueComponent } from '../idea-add-dialogue/idea-add-dialogue.component';

@Component({
  selector: 'app-ideas-list',
  templateUrl: './ideas-list.component.html',
  styleUrls: ['./ideas-list.component.scss']
})
export class IdeasListComponent implements OnInit {

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
        (data) => {
          this.ideas = data;
          this.dataSource = new MatTableDataSource(this.ideas);
          this.dataSource.sort = this.sort;
      });
    this.refresh();
  }

  navigateTo(row: any) {
    this.router.navigate(['/bright/ideas/' + row.id]);
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
        (data) => {
          this.ideas = data;
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
        dialogRef = this.dialog.open(IdeaEditDialogueComponent, {
          width: '270px',
          data: idea
      });

    } else {
        console.log('opening Add Idea');
        dialogRef = this.dialog.open(IdeaAddDialogueComponent, {
          width: '270px',
          data: new Idea()
      });
    }

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed, result: ' + result);
      this.refresh();
      this.idea = undefined;
    });
  }

}
