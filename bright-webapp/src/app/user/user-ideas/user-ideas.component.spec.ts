import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserIdeasComponent } from './user-ideas.component';

describe('UserIdeasComponent', () => {
  let component: UserIdeasComponent;
  let fixture: ComponentFixture<UserIdeasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserIdeasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserIdeasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
