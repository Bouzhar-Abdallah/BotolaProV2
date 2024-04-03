import { Routes } from "@angular/router";
import { PageComponent } from "../features/home/page/page.component";
import { HomeComponent } from "../features/championship/home/home.component";
import { HomeArticlesComponent } from "../features/articles/home-articles/home-articles.component";
import { HomeDashboardComponent } from "../features/dashboard/home-dashboard/home-dashboard.component";
import { ManageArticlesComponent } from "../features/dashboard/home-dashboard/manage-articles/manage-articles.component";
import { ArticlePageComponent } from "../features/articles/article-page/article-page.component";



export const routes: Routes =[

    { path: 'home', component: PageComponent , data: {animation: 'newQuestion'} },
    { path: 'championship', component: HomeComponent},
    { path: 'articles', component: HomeArticlesComponent},
    { path: 'dashboard/acceuil', component: HomeDashboardComponent},
    { path: 'dashboard/managment', component: ManageArticlesComponent},
    { path: 'articles/:id', component: ArticlePageComponent},
 
    
    { path: '', redirectTo: '/championship', pathMatch:'full'}
  ]