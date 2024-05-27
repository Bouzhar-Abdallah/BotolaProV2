import { Routes } from "@angular/router";
import { PageComponent } from "../features/home/page/page.component";
import { HomeComponent } from "../features/championship/home/home.component";
import { HomeArticlesComponent } from "../features/articles/home-articles/home-articles.component";
import { HomeDashboardComponent } from "../features/dashboard/home-dashboard/home-dashboard.component";
import { ManageArticlesComponent } from "../features/dashboard/home-dashboard/manage-articles/manage-articles.component";
import { ArticlePageComponent } from "../features/articles/article-page/article-page.component";
import { LoginComponent } from "../features/auth/login/login.component";
import { authentificationGuard } from "../guards/authentification.guard";
import { AdminComponent } from "../temp/admin/admin.component";
import { UserComponent } from "../temp/user/user.component";
import { RedactorComponent } from "../temp/redactor/redactor.component";
import { UnAuthorizedComponent } from "../shared/un-authorized/un-authorized.component";
import { userGuard } from "../guards/user.guard";
import { adminGuard } from "../guards/admin.guard";
import { redactorGuard } from "../guards/redactor.guard";



export const routes: Routes =[

    { path: 'home', component: PageComponent , data: {animation: 'newQuestion'} },
    { path: 'championship', component: HomeComponent},
    { path: 'articles', component: HomeArticlesComponent},

    /* { path: 'dashboard/acceuil', component: HomeDashboardComponent},
    { path: 'dashboard/managment', component: ManageArticlesComponent}, */
    
    //{ path: 'admin/home', component: AdminComponent},
    //{ path: 'user/home', component: UserComponent},
    //{ path: 'redactor/home', component: RedactorComponent},
    {
      path: 'user',
      canActivateChild: [userGuard],
      children:[
        {
          path: 'home',
          component: UserComponent
        }
      ]
    },
    {
      path: 'admin',
      canActivateChild: [adminGuard],
      children:[
        {
          path: 'home',
          component: AdminComponent
        }
      ]
    },
    {
      path: 'redactor',
      canActivateChild: [adminGuard],
      children:[
        {
          path: 'home',
          component: RedactorComponent
        }
      ]
    },
    {
      path: 'dashboard',
      canActivate: [authentificationGuard], // Utilisation du guard
      children: [
        {
          path: 'acceuil',
          component: HomeDashboardComponent
        },
        {
          path: 'managment',
          component: ManageArticlesComponent
        }
      ]
    },
    { path: 'articles/:id', component: ArticlePageComponent},
    { path: 'login', component: LoginComponent},
    { path: 'unauth', component: UnAuthorizedComponent},
 
    
    { path: '', redirectTo: '/championship', pathMatch:'full'}
  ]