import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LetterScrollComponent } from './letter-scroll.component';

describe('LetterScrollComponent', () => {
  let component: LetterScrollComponent;
  let fixture: ComponentFixture<LetterScrollComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LetterScrollComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LetterScrollComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
