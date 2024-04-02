import { Component } from '@angular/core';
import { Article } from 'src/app/models/article';
import { ArticlesService } from 'src/app/services/articles.service';

@Component({
  selector: 'app-home-articles',
  templateUrl: './home-articles.component.html',
  styleUrls: ['./home-articles.component.scss'],
})
export class HomeArticlesComponent {
  constructor(private articleService: ArticlesService) {}

  articles: Article[]= [];

  ngOnInit(){
    this.articleService.loadAll().subscribe((articles)=>{
      this.articles = articles
    })
  }
}
