import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IdeasGridComponent } from './ideas-grid.component';

describe('IdeasGridComponent', () => {
  let component: IdeasGridComponent;
  let fixture: ComponentFixture<IdeasGridComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IdeasGridComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IdeasGridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
