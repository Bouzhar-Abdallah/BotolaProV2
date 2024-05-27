import { Component } from '@angular/core';

import { FormBuilder, FormGroup } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
  formRegister!: FormGroup;
  constructor(private fb: FormBuilder, private authService: AuthService) {}
  ngOnInit(): void {
    this.formRegister = this.fb.group({
      firstName: this.fb.control(""),
      lastName: this.fb.control(""),
      email: this.fb.control(""),
      phoneNumber: this.fb.control(""),
      password: this.fb.control(""),
      password_confirmation: this.fb.control("")
    })
  }
  handleRegister(){
    this.authService.register(this.formRegister.value).subscribe({
      next: value =>{
        
        let data : any = value
        localStorage.setItem("token", data['access-token'])
        
 
        this.authService.loadProfile()
      },
      error: error =>{
        console.log(error)
      }
    })
  }
}
