import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { API_BASE_URL } from '../globals/globals';
import { Article } from '../models/article';

@Injectable({
  providedIn: 'root'
})
export class ArticlesService {

  private levelsURL = API_BASE_URL + 'article';

  constructor(private http: HttpClient) {}

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'}),
  };

  loadAll() {
    return this.http.get<Article[]>(this.levelsURL + '/getAll');
  }
  add(article: FormData) {
    console.log("articleService")
    return this.http.post<Article>(this.levelsURL, article);
  }
  update(article: Article) {
    return this.http.put<Article>(this.levelsURL + article.id, article, this.httpOptions);
  }
  delete(id: number) {
    return this.http.delete<Article>(this.levelsURL + id);
  }
  getById(id: number) {
    return this.http.get<Article>(this.levelsURL + id);
  }
}
