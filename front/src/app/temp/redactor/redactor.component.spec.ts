import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RedactorComponent } from './redactor.component';

describe('RedactorComponent', () => {
  let component: RedactorComponent;
  let fixture: ComponentFixture<RedactorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RedactorComponent]
    });
    fixture = TestBed.createComponent(RedactorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
