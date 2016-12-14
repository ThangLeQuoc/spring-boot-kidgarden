import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { Article } from './article';

@Injectable()
export class ArticleService {

    constructor(private http: Http) {

    }

    // get article by category
    getByCategory(categoryShortName: String): Promise<Article[]> {
        return this.http.get('http://localhost:8080/' + categoryShortName + '/articles')
            .toPromise().then(response => response.json()).catch(this.handleError);
    }

    // get article detail by id
    getByArticleId(categoryShortName: String, articleId: String): Promise<Article> {
        return this.http.get('http://localhost:8080/'+categoryShortName+'/articles/'+ articleId)
        .toPromise().then(response => response.json()).catch(this.handleError);
    }


    handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }


}