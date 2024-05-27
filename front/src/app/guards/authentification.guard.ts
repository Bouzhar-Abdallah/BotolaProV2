import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

export const authentificationGuard: CanActivateFn = (route, state) => {
  const auth = inject(AuthService);
  const router = inject(Router)
  if (!auth.isAthenticated) {
    router.navigateByUrl("/login")
    return false;
  }
  return true;
};
