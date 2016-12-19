import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { MaterialModule } from '@angular/material';
import { AUTH_PROVIDERS }      from 'angular2-jwt';

import 'hammerjs';


import { AppComponent } from './app.component';
import { ArticleComponent } from './article/article.component';
import { ArticleDetailComponent } from './article-detail/article-detail.component';

// singleton service
import { UserService } from './services/user.service';

// import routing
import { routing } from './app.routing';


@NgModule({
  declarations: [
    AppComponent,
    ArticleComponent,
    ArticleDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing,
    MaterialModule.forRoot()
  ],
  providers: [AUTH_PROVIDERS,UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
