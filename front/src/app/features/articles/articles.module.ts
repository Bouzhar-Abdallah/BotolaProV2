import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeArticlesComponent } from './home-articles/home-articles.component';
import { ArticlePageComponent } from './article-page/article-page.component';
import { RouterModule } from '@angular/router';
import { routes } from 'src/app/routing/routes';



@NgModule({
  declarations: [
    HomeArticlesComponent,
    ArticlePageComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
  ]
})
export class ArticlesModule { }
