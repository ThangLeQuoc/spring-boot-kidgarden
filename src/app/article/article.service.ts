import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
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
        return this.http.get('http://localhost:8080/' + categoryShortName + '/articles/' + articleId)
            .toPromise().then(response => response.json()).catch(this.handleError);
    }

    postArticle(article: Article): Promise<any> {
        //let headers = new Headers({'Content-Type': 'application/json'});
        let headers = new Headers({ 'Content-Type': 'application/x-www-form-urlencoded' });
        let options = new RequestOptions({ headers: headers });
        let requestBody: String = '';
        for (let prop in article) {
            requestBody = requestBody + prop + '=' + article[prop] + '&';
        }

        // cut off the last character '&'
        requestBody = requestBody.substring(0, requestBody.length - 1);

        let message: String = '';
        let editor = article.editor;
        return this.http.post('http://localhost:8080/administrator/' + editor + '/post/article', requestBody, { headers: headers }).toPromise()
            .then(response => {
                if(response.status === 200){
                    return 'New article created successfully';
                }
                else{
                    return 'Error occurred when creating new article';
                }
            }).catch(this.handleError);
    }

    handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }


}