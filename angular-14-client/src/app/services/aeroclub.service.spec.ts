import { TestBed } from '@angular/core/testing';

import { AeroclubService } from './aeroclub.service';

describe('AeroclubService', () => {
  let service: AeroclubService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AeroclubService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
