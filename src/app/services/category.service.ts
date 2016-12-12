import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Category } from './category';
import 'rxjs/add/operator/toPromise';


@Injectable()
export class CategoryService {
    constructor(private http: Http){

    }
    getCategories(): Promise<Category[]>{
        return this.http.get('http://localhost:8080/categories').toPromise()
            .then(response => response.json() as Category[]).catch(this.handleError); 
    }

    // handle error
  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}