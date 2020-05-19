import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserEditDialogueComponent } from './user-edit-dialogue.component';

describe('UserEditDialogueComponent', () => {
  let component: UserEditDialogueComponent;
  let fixture: ComponentFixture<UserEditDialogueComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserEditDialogueComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserEditDialogueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
