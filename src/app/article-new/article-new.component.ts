import { Component, OnInit } from '@angular/core';
import { Article } from '../article/article';
import { ArticleService } from '../article/article.service';

import { Category } from '../services/category';
import { CategoryService } from '../services/category.service';
@Component({
  selector: 'app-article-new',
  templateUrl: './article-new.component.html',
  styleUrls: ['./article-new.component.css'],
  providers: [ArticleService, CategoryService]
})
export class ArticleNewComponent implements OnInit {

  article: Article = new Article();
  message: String = '';
  categories: Category[];
  constructor(private categoryService: CategoryService,
              private articleService: ArticleService) { }

  ngOnInit() {
    this.getCategories();
  }

  // get category List
  getCategories(): void {
    this.categoryService.getCategories()
      .then(Category => {
        this.categories = Category;
        this.article
      });
  }

  publishArticle(): void {
    let profile = localStorage.getItem('profile');
    let profileJSON = JSON.parse(profile);
    this.article.editor = profileJSON.username;
    this.article.dayofpublish = this.currentDay();

    this.articleService.postArticle(this.article).then(message => {
      this.message = message;
      this.article.resetField();
    });
  }



  currentDay(): String {
    let today: Date = new Date();
    let dd = today.getDate();
    let mm = today.getMonth() + 1; //January is 0!

    let yyyy = today.getFullYear();
    if (dd < 10) {
      dd = 0 + dd;
    }
    if (mm < 10) {
      mm = 0 + mm;
    }
    let todayString = yyyy + '-' + mm + '-' + dd;
    return todayString;
  }

}
