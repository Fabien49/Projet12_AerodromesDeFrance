import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AeroclubListComponent } from './aeroclub-list.component';

describe('TutorialsListComponent', () => {
  let component: AeroclubListComponent;
  let fixture: ComponentFixture<AeroclubListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AeroclubListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AeroclubListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
