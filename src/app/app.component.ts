import { Component, OnInit, AfterViewInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';

import { Category } from './services/category';
import { CategoryService } from './services/category.service';
import { User } from './services/user';
import { UserService } from './services/user.service';

import { Auth } from './services/auth.service';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [CategoryService, Auth]
})


export class AppComponent implements OnInit  {
  user: User = new User;
  username: String;
  categories: Category[];
  profile: any;
  constructor(private categoryService: CategoryService,
              private auth: Auth,
              private userService: UserService,
              private router: Router) {

  }

  loggedIn: boolean = false;
  // get category List
  getCategories(): void {
    this.categoryService.getCategories()
      .then(Category => {
        this.categories = Category;
      });
  }
  ngOnInit() {
    this.getCategories();
  }


  signIn() {
    if (!this.auth.authenticated()) {
      this.auth.login();
    }

  }

  checkProfile() {
    if(this.auth.authenticated()) {
      this.loggedIn = false;
      let profile = localStorage.getItem('profile');
      if(profile === null)
        return false;
      else
        {
          let profileJSON = JSON.parse(profile);
          this.user.name = profileJSON.name;
          this.user.username = profileJSON.username;
          this.user.email = profileJSON.email;
          this.user.facebook = profileJSON.facebook;
          this.user.phonenumber = profileJSON.phonenumber;

          this.userService.logIn();
          this.loggedIn = true;
          return true;
        }
    }
    return false;
  }

  feelTheInfo() {
    let profile = localStorage.getItem('profile');
    console.log(profile);
    let json = JSON.parse(profile);
    console.log(json.name);
  }

  createNewPost(){
    this.router.navigate(['/administrator/create']);
  }
}
