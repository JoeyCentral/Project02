import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor(private router: Router, private httpClient: HttpClient) { }

  authenticated = false; 

  async loginHttp(credentails: {username: string, password: string}){
    const loginCredentials = {
      username: credentails.username,
      password: credentails.password,
    };
// NOTE: Until server is up, we are using localhost. If your post isn't 8081, fix it in lines 21 and 34.
    const url = "http://localhost:8081/start/login";
    const userID = await this.httpClient.post(url, loginCredentials).toPromise();
    var b = JSON.parse(JSON.stringify(userID));
    if (b == 0) this.authenticated = false;
    else this.authenticated = true;
    return this.authenticated;
  }

  async createHttp(credentails: {username: string, password: string}){
    const loginCredentials = {
      username: credentails.username,
      password: credentails.password,
    };
    const url = "http://localhost:8081/start/create";
    const userID = await this.httpClient.post(url, loginCredentials).toPromise();
    var b = JSON.parse(JSON.stringify(userID));
    if (b == 0) this.authenticated = false;
    else this.authenticated = true;
    return this.authenticated;
  }
}
