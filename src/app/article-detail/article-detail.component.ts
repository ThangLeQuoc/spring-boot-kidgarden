import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { Article } from '../article/article';
import { ArticleService } from '../article/article.service';

import 'rxjs/add/operator/switchMap';

@Component({
  selector: 'app-article-detail',
  templateUrl: './article-detail.component.html',
  styleUrls: ['./article-detail.component.css'],
  providers: [ArticleService]
})
export class ArticleDetailComponent implements OnInit {

  selectedArticle: Article

  constructor(private articleService: ArticleService,
    private route: ActivatedRoute,
    private location: Location) { }

  ngOnInit() {
    this.route.params
      .switchMap((params: Params) => this.articleService.getByArticleId(params['categorypath'], params['id']))
      .subscribe(Article => this.selectedArticle = Article);
  }

  goBack(): void {
    this.location.back();
  }

}
