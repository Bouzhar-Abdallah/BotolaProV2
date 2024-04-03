import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Article } from 'src/app/models/article';
import { ArticlesService } from 'src/app/services/articles.service';

@Component({
  selector: 'app-manage-articles',
  templateUrl: './manage-articles.component.html',
  styleUrls: ['./manage-articles.component.scss']
})
export class ManageArticlesComponent {
  constructor(public dialog: MatDialog, private acrticleService: ArticlesService) {}
  

  public articles!: Article[]; 
  
public pageNumber: number = 0;
public pageSize: number = 5;
public totalPages!: number;
  
  ngOnInit() {

    this.getArticles()
  }
  getArticles(){
    this.acrticleService.loadAll(this.pageNumber,this.pageSize).subscribe((articles)=>{
      this.articles = articles.content
    this.pageNumber = articles.pageable.pageNumber
    this.pageSize = articles.pageable.pageSize
    this.totalPages = articles.totalPages
    console.log('total pages ',this.totalPages)
    })
    
  }
  setPage(pageNu: number){
    this.pageNumber = pageNu
    this.getArticles()
  }
}
