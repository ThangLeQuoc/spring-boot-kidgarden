import { Injectable } from '@angular/core';
import { User } from './user';
import 'rxjs/add/operator/toPromise';


@Injectable()
export class UserService {
    loggedIn: boolean;
    constructor(){
        this.loggedIn = false;
    }
    isLoggedIn(){
        return this.loggedIn;
    }

    logIn(){
        this.loggedIn = true;
    }
    logOut(){
        this.loggedIn = false;
    }


}