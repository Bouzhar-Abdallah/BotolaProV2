import { Routes } from "@angular/router";
import { PageComponent } from "../features/home/page/page.component";
import { HomeComponent } from "../features/championship/home/home.component";
import { HomeArticlesComponent } from "../features/articles/home-articles/home-articles.component";
import { HomeDashboardComponent } from "../features/dashboard/home-dashboard/home-dashboard.component";



export const routes: Routes =[

    { path: 'home', component: PageComponent , data: {animation: 'newQuestion'} },
    { path: 'championship', component: HomeComponent},
    { path: 'articles', component: HomeArticlesComponent},
    { path: 'dashboard', component: HomeDashboardComponent},
    
 
    
    { path: '', redirectTo: '/championship', pathMatch:'full'}
  ]