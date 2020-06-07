import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IdeaFilterComponent } from './idea-filter.component';

describe('IdeaFilterComponent', () => {
  let component: IdeaFilterComponent;
  let fixture: ComponentFixture<IdeaFilterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IdeaFilterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IdeaFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
