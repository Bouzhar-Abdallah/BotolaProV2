import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeArticlesComponent } from './home-articles/home-articles.component';
import { ArticlePageComponent } from './article-page/article-page.component';
import { RouterModule } from '@angular/router';
import { routes } from 'src/app/routing/routes';
import { FormsModule } from '@angular/forms';
import { PaginatorModule } from 'primeng/paginator';


@NgModule({
  declarations: [
    HomeArticlesComponent,
    ArticlePageComponent,
    
  ],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
    FormsModule,
    PaginatorModule
  ]
})
export class ArticlesModule { }
