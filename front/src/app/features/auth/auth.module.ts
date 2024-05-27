import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { routes } from 'src/app/routing/routes';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { RegisterComponent } from './register/register.component';



@NgModule({
  declarations: [LoginComponent, RegisterComponent],
  imports: [
    RouterModule.forRoot(routes),
    CommonModule,
    ReactiveFormsModule
  ]
})
export class AuthModule { }
