import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IdeasListComponent } from './ideas-list.component';

describe('IdeasListComponent', () => {
  let component: IdeasListComponent;
  let fixture: ComponentFixture<IdeasListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IdeasListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IdeasListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
