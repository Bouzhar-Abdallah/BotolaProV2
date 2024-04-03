import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders, HttpParams } from '@angular/common/http';
import { API_BASE_URL } from '../globals/globals';
import { Article, PagesArticle } from '../models/article';

@Injectable({
  providedIn: 'root'
})
export class ArticlesService {

  private levelsURL = API_BASE_URL + 'article';

  constructor(private http: HttpClient) {}

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'}),
  };

  loadAll(pageNo: number = 0, pageSize: number=10) {
    let params = new HttpParams();

    params = params.append('pageNo', pageNo.toString());
    params = params.append('pageSize', pageSize.toString());
    return this.http.get<PagesArticle>(this.levelsURL + '/getAll',{ params: params });
  }
  loadLatest() {
    return this.http.get<Article[]>(this.levelsURL + '/latest');
  }
  loadMostRead() {
    return this.http.get<Article[]>(this.levelsURL + '/mostRead');
  }
  add(article: FormData) {
    console.log("articleService")
    return this.http.post<Article>(this.levelsURL, article);
  }
  update(article: Article) {
    return this.http.put<Article>(this.levelsURL + article.id, article, this.httpOptions);
  }
  delete(id: number) {
    return this.http.delete<Article>(this.levelsURL +'/'+ id);
  }
  getById(id: number) {
    return this.http.get<Article>(this.levelsURL +'/'+ id);
  }
  search(string:string){
    return this.http.get<Article>(this.levelsURL +'/search/'+ string);
  }
}
