import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  inputUsername = '';
  inputPassword = '';
  verifyPassword = '';

  notValid = false;
  badPass = false;
  loggedIn=false;
  m1 = true;
  m2 = true;
  constructor(private loginService: LoginService) { }

  ngOnInit() {
  }

  async submitLogin() {
    const verify = {
      username: this.inputUsername,
      password: this.inputPassword
    };
    const loginSuccessful = await this.loginService.loginHttp(verify);
    if (!loginSuccessful) {
      this.notValid = true;
    } else {
      this.m1 = false;
      this.loggedIn = true;
    }
  }

  async submitCreate() {
    if (this.inputPassword == this.verifyPassword && this.verifyPassword != '') {
      const verify = {
        username: this.inputUsername,
        password: this.inputPassword
      };

      const loginSuccessful = await this.loginService.createHttp(verify);
      if (!loginSuccessful) {
        this.notValid = true;
      } else {
        this.m2 = false;
        this.loggedIn = true;
      }
    } else {
      this.badPass = true;
    }
  }
}
