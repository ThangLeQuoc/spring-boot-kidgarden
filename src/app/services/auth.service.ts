// app/auth.service.ts

import { Injectable } from '@angular/core';
import { tokenNotExpired } from 'angular2-jwt';
import { User } from './user';

// Avoid name not found warnings
let Auth0Lock = require('auth0-lock').default;

let options = {
  rememberLastLogin: false
};

let authAccessToken: any;

@Injectable()
export class Auth {
  // Configure Auth0
  lock = new Auth0Lock('tD2o9agw415Fge3n7vwbY2Av27vyP8AM', 'thangle.auth0.com', options);
  
  constructor() {
    // Add callback for lock `authenticated` event
    let user: User = new User;
    this.lock.on('authenticated', (authResult) => {
       localStorage.setItem('id_token', authResult.idToken);
       authAccessToken = authResult.accessToken;
      this.lock.getUserInfo(authAccessToken, function (error, profile) {
        if (error) {
          console.log(error);
          return;
        }
        localStorage.setItem('profile', JSON.stringify(profile));
        //return profile;
      });
      this.lock.hide();

    });
  }

  public login() {
    // Call the show method to display the widget.
    this.lock.show();
  }

  public authenticated() {
    // Check if there's an unexpired JWT
    // This searches for an item in localStorage with key == 'id_token'
    return tokenNotExpired();
  }

  public logout() {
    // Remove token from localStorage
    localStorage.removeItem('id_token');
    localStorage.removeItem('profile');
  }
}


