import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAeroclubComponent } from './add-aeroclub.component';

describe('AddTutorialComponent', () => {
  let component: AddAeroclubComponent;
  let fixture: ComponentFixture<AddAeroclubComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddAeroclubComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddAeroclubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
