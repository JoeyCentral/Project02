import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  inputUsername = '';
  inputPassword = '';

  isValid = false; //to validate if password and username exist 
  constructor() { }

  ngOnInit() {
  }

  async submit(){
    const verify = {
      username: this
    }
  }

}
