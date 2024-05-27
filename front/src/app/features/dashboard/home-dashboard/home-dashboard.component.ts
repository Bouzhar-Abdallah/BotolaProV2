import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Article } from 'src/app/models/article';
import { ArticlesService } from 'src/app/services/articles.service';
import { DialogContentComponent } from 'src/app/shared/dialog-content/dialog-content.component';

@Component({
  selector: 'app-home-dashboard',
  templateUrl: './home-dashboard.component.html',
  styleUrls: ['./home-dashboard.component.scss'],
})
export class HomeDashboardComponent {
  constructor(public dialog: MatDialog, private acrticleService: ArticlesService) {}
  

  public latestArticles!: Article[]; 
  public mostReadArticles!: Article[]; 

  
  ngOnInit() {

    this.acrticleService.loadLatest().subscribe((latest)=>{
      this.latestArticles = latest
      console.log(latest)
    })
    this.acrticleService.loadMostRead().subscribe((MostRead)=>{
      this.mostReadArticles = MostRead
    })
  }
}
