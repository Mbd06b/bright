import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IdeasCardComponent } from './ideas-card.component';

describe('IdeasCardComponent', () => {
  let component: IdeasCardComponent;
  let fixture: ComponentFixture<IdeasCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IdeasCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IdeasCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
