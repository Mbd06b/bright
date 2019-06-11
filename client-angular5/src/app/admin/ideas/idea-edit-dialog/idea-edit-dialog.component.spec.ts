import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IdeaEditDialogComponent } from './idea-edit-dialog.component';

describe('IdeaEditDialogComponent', () => {
  let component: IdeaEditDialogComponent;
  let fixture: ComponentFixture<IdeaEditDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IdeaEditDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IdeaEditDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
