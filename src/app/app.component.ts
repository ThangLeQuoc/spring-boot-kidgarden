import { Component, OnInit } from '@angular/core';
import { Category } from './services/category';
import { CategoryService } from './services/category.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [CategoryService]
})


export class AppComponent {
  title = 'app works!';

  categories: Category[];

  constructor(private categoryService: CategoryService){

  }

  // get category List
  getCategories(): void {
    this.categoryService.getCategories()
      .then(Category => {
        this.categories = Category;
      });
  }
  ngOnInit(){
    this.getCategories();
  }

}
