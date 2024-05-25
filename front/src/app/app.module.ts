import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './routing/app-routing.module';
import { AppComponent } from './app.component';
import { SharedModule } from './shared/shared.module';
import { RouterModule } from '@angular/router';
import { routes } from './routing/routes';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { ArticlesModule } from './features/articles/articles.module';
import { ChampionshipModule } from './features/championship/championship.module';

import { DashboardModule } from './features/dashboard/dashboard.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MAT_DIALOG_DEFAULT_OPTIONS, MatDialogModule} from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { PipesModule } from './pipes/pipes.module';
import { LoginComponent } from './features/auth/login/login.component';
import { AuthModule } from './features/auth/auth.module';
import { TokenHttpInterceptor } from './interceptors/token-http.interceptor';
import { UserComponent } from './temp/user/user.component';
import { AdminComponent } from './temp/admin/admin.component';
import { RedactorComponent } from './temp/redactor/redactor.component';


@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    AdminComponent,
    RedactorComponent,

  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    SharedModule,
    HttpClientModule,
    CommonModule,
    PipesModule,
    ArticlesModule,
    ChampionshipModule,
    AuthModule,
    DashboardModule,
    BrowserAnimationsModule,
    MatDialogModule,
    MatButtonModule,
    FormsModule,
    
  ],
  providers: [AppRoutingModule,
    {provide: MAT_DIALOG_DEFAULT_OPTIONS, useValue: {hasBackdrop: true, ariaModal:false}},
    {provide: HTTP_INTERCEPTORS, useClass: TokenHttpInterceptor, multi:true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
