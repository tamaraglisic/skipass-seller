import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PoliciesViewComponent } from './policies-view.component';

describe('PoliciesViewComponent', () => {
  let component: PoliciesViewComponent;
  let fixture: ComponentFixture<PoliciesViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PoliciesViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PoliciesViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
