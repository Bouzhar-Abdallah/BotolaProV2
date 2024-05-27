import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeDashboardComponent } from './home-dashboard/home-dashboard.component';
import { RouterModule } from '@angular/router';
import { routes } from 'src/app/routing/routes';
import { ManageArticlesComponent } from './home-dashboard/manage-articles/manage-articles.component';
import { NavbarDashboardComponent } from './home-dashboard/navbar-dashboard/navbar-dashboard.component';



@NgModule({
  declarations: [
    HomeDashboardComponent,
    ManageArticlesComponent,
    NavbarDashboardComponent,
  ],
  imports: [
    RouterModule.forRoot(routes),
    CommonModule
  ]
})
export class DashboardModule { }
