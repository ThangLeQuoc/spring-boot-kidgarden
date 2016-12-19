import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { ArticleService } from './article.service';
import { Article } from './article';

import { UserService } from '../services/user.service';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css'],
  providers: [ArticleService]
})
export class ArticleComponent implements OnInit {

  
  constructor(private articleService: ArticleService,
              private userService: UserService,
              private router: Router,
              private route: ActivatedRoute) { }

  articles: Article[];
  selectedArticle: Article;
  selectedCategory: String;
  isHidden: boolean = false;

  status: any = this.userService.isLoggedIn();

  getArticleList(categoryPath: String): void {
    this.articleService.getByCategory(categoryPath).then(Articles => {
      this.articles = Articles;
    });
  }

  selectArticle(article: Article):void {
    this.router.navigate([this.selectedCategory,'articles', article.article_id]);
    //this.router.navigate
  }


  ngOnInit() {
    this.route.params.forEach((params: Params) => {
      this.selectedCategory = params['categorypath'];

      // no parameter specified, get all articles      
      if (this.selectedCategory === undefined) {
        this.selectedCategory = 'all';
        this.getArticleList('all');
      }
      else {
        this.getArticleList(this.selectedCategory);
      }
    });
  }

}
