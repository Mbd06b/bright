import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IdeasNavigationComponent } from './ideas-navigation.component';

describe('IdeasNavigationComponent', () => {
  let component: IdeasNavigationComponent;
  let fixture: ComponentFixture<IdeasNavigationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IdeasNavigationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IdeasNavigationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
