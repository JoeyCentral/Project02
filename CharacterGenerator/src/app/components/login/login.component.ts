import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from '../../services/login-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  inputUsername = '';
  inputPassword = '';

  notValid = false; //to validate if password and username exist 
  constructor(private loginService: LoginServiceService) { }

  ngOnInit() {
  }
  async submit(){
    const verify = {
      username: this.inputUsername,
      password: this.inputPassword
    };
    const loginSuccessful = await this.loginService.loginHttp(verify);
    console.log(loginSuccessful);
    if (!loginSuccessful) {
      this.notValid = true;
    }
    console.log(this.notValid);
  }
}
