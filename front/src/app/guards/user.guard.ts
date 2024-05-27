import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

export const userGuard: CanActivateFn = (route, state) => {
  const auth = inject(AuthService);
  const router = inject(Router);
  if (!auth.isAuthenticated()) {
    router.navigateByUrl('/login');
    return false;
  }

  if (!auth.isUser()) {
    router.navigateByUrl('/unauth');
  } else {
    return true;
  }

  return false;
};