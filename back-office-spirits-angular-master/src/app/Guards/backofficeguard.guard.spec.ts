import { TestBed } from '@angular/core/testing';

import { BackofficeguardGuard } from './backofficeguard.guard';

describe('BackofficeguardGuard', () => {
  let guard: BackofficeguardGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(BackofficeguardGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
