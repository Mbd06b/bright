import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IdeaEditDialogueComponent } from './idea-edit-dialogue.component';

describe('IdeaEditDialogueComponent', () => {
  let component: IdeaEditDialogueComponent;
  let fixture: ComponentFixture<IdeaEditDialogueComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IdeaEditDialogueComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IdeaEditDialogueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
