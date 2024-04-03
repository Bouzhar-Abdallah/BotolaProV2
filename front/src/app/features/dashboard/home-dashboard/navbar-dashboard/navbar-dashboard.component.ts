import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { DialogContentComponent } from 'src/app/shared/dialog-content/dialog-content.component';

@Component({
  selector: 'app-navbar-dashboard',
  templateUrl: './navbar-dashboard.component.html',
  styleUrls: ['./navbar-dashboard.component.scss']
})
export class NavbarDashboardComponent {
  constructor(public dialog: MatDialog, private route: ActivatedRoute) {}
  public screenWidth: any;
public currentRoute!: string;
  openDialog(
    enterAnimationDuration: string,
    exitAnimationDuration: string
  ): void {
    this.dialog.open(DialogContentComponent, {
      enterAnimationDuration,
      exitAnimationDuration,
      width: this.screenWidth,
    });
    console.log('screenWidth  ', this.screenWidth);
  }
  ngOnInit() {
    this.screenWidth = window.innerWidth * 0.85;
    const url = this.route.snapshot.url;
    this.currentRoute = url[url.length - 1].path;
  }
}
