import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

export const adminGuard: CanActivateFn = (route, state) => {
  const auth = inject(AuthService);
  const router = inject(Router);
  
console.log("admin guard trigred")
if (!auth.isAdmin() || !auth.isAuthenticated()) {
    console.log("is not admin")
    router.navigateByUrl('/unauth');
  } else {
    return true;
  }

  return false;
};
