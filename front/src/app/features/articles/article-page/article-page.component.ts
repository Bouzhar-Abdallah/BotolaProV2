import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Article } from 'src/app/models/article';
import { ArticlesService } from 'src/app/services/articles.service';

@Component({
  selector: 'app-article-page',
  templateUrl: './article-page.component.html',
  styleUrls: ['./article-page.component.scss']
})
export class ArticlePageComponent {
constructor(private route: ActivatedRoute, private articleService: ArticlesService){}
articleId!: number;
article!: Article;
ngOnInit() {
  
  const url = this.route.snapshot.url;
  this.articleId = parseInt(url[url.length - 1].path);

  this.articleService.getById(this.articleId).subscribe((article)=>{
    this.article = article;
    console.log(article)
  })
}
}
