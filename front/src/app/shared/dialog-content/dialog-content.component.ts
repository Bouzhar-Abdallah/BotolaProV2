import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { Article } from 'src/app/models/article';
import { ArticlesService } from 'src/app/services/articles.service';

@Component({
  selector: 'app-dialog-content',
  templateUrl: './dialog-content.component.html',
  styleUrls: ['./dialog-content.component.scss'],
  standalone: true,
  imports: [MatDialogModule, MatButtonModule, ReactiveFormsModule],
})
export class DialogContentComponent implements OnInit {
  constructor(
    private fb: FormBuilder,
    private articleService: ArticlesService
  ) {}
  articleForm!: FormGroup;
  close: boolean = false;
  ngOnInit(): void {
    this.articleForm = this.fb.group({
      title: ['', Validators.required],
      content: [''],
      image: [''],
    });
  }
  onFileSelect(event: any) {
    if (event.target.files.length > 0) {
      this.selectedFile = event.target.files[0];
    }
  }
  selectedFile: File | null = null;
  
  
  onSubmit() {
    console.log("selected file",this.selectedFile); 
    const formData = new FormData();
    
    // Append title and content to formData
    formData.append('title', this.articleForm.get('title')?.value);
    formData.append('content', this.articleForm.get('content')?.value);
    
    // Append image to formData
    if (this.selectedFile) {
      formData.append('image', this.selectedFile);
    }

    // Log FormData
    formData.forEach((value, key) => {
      console.log(`${key}: ${value}`);
    });
    
    // Send POST request
    this.articleService.add(formData).subscribe((res) => {
      
        this.close = true
      
    });
  }
}
