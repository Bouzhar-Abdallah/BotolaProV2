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

  articles: Article[] = [];
  public pageNumber: number = 0;
  public pageSize: number = 30;
  public searchText: string = '';
  ngOnInit() {
    this.loadArticles();
  }
  loadArticles() {
    this.articleService.loadAll().subscribe((articles) => {
      this.articles = articles.content;
      this.pageNumber = articles.pageable.pageNumber;
      this.pageSize = articles.pageable.pageSize;
    });
  }
  search() {
    this.articleService.search(this.searchText).subscribe((articles)=>{
      console.log(articles)
    })
  }
}
