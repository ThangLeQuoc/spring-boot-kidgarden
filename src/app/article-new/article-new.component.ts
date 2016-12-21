import { Component, OnInit } from '@angular/core';
import { Article } from '../article/article';
import { ArticleService } from '../article/article.service';

import { Category } from '../services/category';
import { CategoryService } from '../services/category.service';
@Component({
  selector: 'app-article-new',
  templateUrl: './article-new.component.html',
  styleUrls: ['./article-new.component.css']
})
export class ArticleNewComponent implements OnInit {

  article: Article = new Article();

  categories: Category[];
  constructor(private categoryService: CategoryService) { }
  ngOnInit() {
    this.getCategories();
  }



  // get category List
  getCategories(): void {
    this.categoryService.getCategories()
      .then(Category => {
        this.categories = Category;
      });
  }

}
