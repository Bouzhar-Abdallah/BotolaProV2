import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StatusPipe } from './status.pipe';



@NgModule({
  declarations: [
    StatusPipe
  ],
  imports: [
    CommonModule
  ]
})
export class PipesModule { }