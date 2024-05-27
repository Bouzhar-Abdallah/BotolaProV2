import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { RouterModule } from '@angular/router';
import { routes } from '../routing/routes';
import { DialogContentComponent } from './dialog-content/dialog-content.component';
import { UnAuthorizedComponent } from './un-authorized/un-authorized.component';




@NgModule({
  declarations: [
    NavbarComponent,
    UnAuthorizedComponent,
    
  ],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
  ],
  exports:[
    NavbarComponent,
    
  ]
})
export class SharedModule { }
