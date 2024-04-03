import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { RouterModule } from '@angular/router';
import { routes } from '../routing/routes';
import { DialogContentComponent } from './dialog-content/dialog-content.component';




@NgModule({
  declarations: [
    NavbarComponent,
    
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
