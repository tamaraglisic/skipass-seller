import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuggestedPoliciesComponent } from './suggested-policies.component';

describe('SuggestedPoliciesComponent', () => {
  let component: SuggestedPoliciesComponent;
  let fixture: ComponentFixture<SuggestedPoliciesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SuggestedPoliciesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SuggestedPoliciesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
