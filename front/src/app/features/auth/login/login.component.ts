import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { jwtDecode } from 'jwt-decode';
import { Token } from 'src/app/models/token';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  formLogin!: FormGroup;
  constructor(private fb: FormBuilder, private authService: AuthService) {}
  ngOnInit(): void {
    this.formLogin = this.fb.group({
      username: this.fb.control(""),
      password: this.fb.control("")
    })
  }
  handleLogin(){
    this.authService.login(this.formLogin.value.username, this.formLogin.value.password).subscribe({
      next: value =>{
        console.log(value)
        
    
        let data : any = value
        localStorage.setItem("token", data['access-token'])
        let token : string | null = localStorage.getItem("token")
        if (token) {
          let decoded_jwt = jwtDecode<Token>(token)
          console.log(decoded_jwt.scope ) 
        }
        this.authService.loadProfile()
      },
      error: error =>{
        console.log(error)
      }
    })
  }
}
