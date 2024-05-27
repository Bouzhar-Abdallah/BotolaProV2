import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { jwtDecode } from 'jwt-decode';
import { Token } from '../models/token';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}
  isAthenticated: boolean = false;
  accessToken!: string;
  username?: string;
  roles!: any;
  
  public login(username: string, password: string) {
    let options = {
      headers: new HttpHeaders().set(
        'Content-Type',
        'application/x-www-form-urlencoded'
      ),
    };
    let params = new HttpParams()
      .set('username', username)
      .set('password', password);
    return this.http.post(
      ' http://localhost:8082/api/v1/auth/login',
      params,
      options
    );
  }

  loadProfile() {
    let data: any = localStorage.getItem("token")
    this.accessToken = data;
    this.isAthenticated = true;
    let decodedJwt: any = jwtDecode(this.accessToken);
    this.username = decodedJwt.sub;
    this.roles = decodedJwt.scope;
  }
  getAccessToken(){
    return localStorage.getItem("token")
  }
  isAuthenticated(){
    return localStorage.getItem("token")
  }

  isUser(){
    
    let token : string | null = localStorage.getItem("token")
    if (!token) {
      return false
    }else{
      let decoded_jwt = jwtDecode<Token>(token)
      if (decoded_jwt.scope != "ROLE_USER") {
        return false
      }
      return true
    }

  }
  isAdmin(){
    
    let token : string | null = localStorage.getItem("token")
    if (!token) {
      return false
    }else{
      let decoded_jwt = jwtDecode<Token>(token)
      if (decoded_jwt.scope != "ROLE_ADMIN") {
        return false
      }
      return true
    }

  }
  isRedactor(){
    
    let token : string | null = localStorage.getItem("token")
    if (!token) {
      return false
    }else{
      let decoded_jwt = jwtDecode<Token>(token)
      if (decoded_jwt.scope != "ROLE_REDACTOR") {
        return false
      }
      return true
    }

  }
}
