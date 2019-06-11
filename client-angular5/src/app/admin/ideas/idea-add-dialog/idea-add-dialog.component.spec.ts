import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IdeaAddDialogComponent } from './idea-add-dialog.component';

describe('IdeaAddDialogComponent', () => {
  let component: IdeaAddDialogComponent;
  let fixture: ComponentFixture<IdeaAddDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IdeaAddDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IdeaAddDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
