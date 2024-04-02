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
  ngOnInit(): void {
    this.articleForm = this.fb.group({
      title: ['', Validators.required],
      content: [''],
      image: [''],
    });
  }
  onSubmit1() {
    /* console.log("onSubmit");

    const formData = new FormData();
    formData.append('title', this.articleForm.get('title')?.value);
    formData.append('content', this.articleForm.get('content')?.value);

    const imageFile = this.articleForm.get('image')?.value;
    if (imageFile) {
      formData.append('image', imageFile);
    }

  
    console.log("Form Data image:", formData.get('image')); 

    this.articleService.add(formData).subscribe((res) => {
      console.log("Response:", res);
    }); */
  }
  onSubmit() {
    const formData = new FormData();
    formData.append('articleDto', new Blob([JSON.stringify({
      title: this.articleForm.get('title')?.value,
      content: this.articleForm.get('content')?.value
    })], {
      type: "application/json"
    }));

    const imageFile: File = this.articleForm.get('image')?.value.file;
    if (imageFile) {
      formData.append('image', imageFile);
    }

    this.articleService.add(formData).subscribe((res) => {
      console.log("Response:", res);
    });
  }
}
