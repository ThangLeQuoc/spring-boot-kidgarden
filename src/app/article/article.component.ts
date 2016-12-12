import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { ArticleService } from './article.service';
import { Article } from './article';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css'],
  providers: [ArticleService]
})
export class ArticleComponent implements OnInit {

  constructor(private articleService: ArticleService,
    private router: Router,
    private route: ActivatedRoute) { }

  articles: Article[];
  selectedArticle: Article;
  isHidden: boolean = false;



  getArticleList(categoryPath: String): void {
    this.articleService.getByCategory(categoryPath).then(Articles => {
      this.articles = Articles;
    });
  }


  ngOnInit() {
    this.route.params.forEach((params: Params) => {
      let choosenCategory = params['categorypath'];

      // no parameter specified, get all articles      
      if (choosenCategory === undefined) {
        this.getArticleList('all');
      }
      else {
        this.getArticleList(choosenCategory);
      }
    });
  }

}
