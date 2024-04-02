import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DialogContentComponent } from 'src/app/shared/dialog-content/dialog-content.component';

@Component({
  selector: 'app-home-dashboard',
  templateUrl: './home-dashboard.component.html',
  styleUrls: ['./home-dashboard.component.scss']
})
export class HomeDashboardComponent {
  constructor(public dialog: MatDialog) {}
    public screenWidth: any;  
  
    openDialog(enterAnimationDuration: string, exitAnimationDuration: string): void {
    this.dialog.open(DialogContentComponent, {
      enterAnimationDuration,
      exitAnimationDuration,
      width: this.screenWidth,
    });
    console.log("screenWidth  ", this.screenWidth)
  }
  ngOnInit() {  
    this.screenWidth = window.innerWidth*0.85;  
    
    this.dialog.open(DialogContentComponent, {
      
      
      width: this.screenWidth,
    });
}  
}
