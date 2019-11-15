import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor(private router: Router, private httpClient: HttpClient) { }

  authenticated = false; 
  pass = "";
  user = "";

  async loginHttp(credentails: {username: string, password: string}){
    const loginCredentials = {
      id: 1,
      username: credentails.username,
      password: credentails.password,
      salt: "salt"
    };


    const url = "http://localhost:8080/start/login";
    const user = await this.httpClient.post(url, loginCredentials).toPromise();
    console.log(user);
    var b = JSON.parse(JSON.stringify(user));
    if (b.username == '') this.authenticated = false;
    else this.authenticated = true;
    console.log(this.authenticated);
    this.pass = b.password;
    this.user = b.username;
​
    return this.authenticated;


    // this.router.navigateByUrl('/profile');
  }
}
