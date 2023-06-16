import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AeroclubDetailsComponent } from './aeroclub-details.component';

describe('AeroclubDetailsComponent', () => {
  let component: AeroclubDetailsComponent;
  let fixture: ComponentFixture<AeroclubDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AeroclubDetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AeroclubDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
