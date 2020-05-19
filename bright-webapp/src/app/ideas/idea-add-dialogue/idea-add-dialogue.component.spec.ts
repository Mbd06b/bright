import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IdeaAddDialogueComponent } from './idea-add-dialogue.component';

describe('IdeaAddDialogueComponent', () => {
  let component: IdeaAddDialogueComponent;
  let fixture: ComponentFixture<IdeaAddDialogueComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IdeaAddDialogueComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IdeaAddDialogueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
