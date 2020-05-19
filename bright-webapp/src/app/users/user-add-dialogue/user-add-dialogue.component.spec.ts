import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserAddDialogueComponent } from './user-add-dialogue.component';

describe('UserAddDialogueComponent', () => {
  let component: UserAddDialogueComponent;
  let fixture: ComponentFixture<UserAddDialogueComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserAddDialogueComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserAddDialogueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
