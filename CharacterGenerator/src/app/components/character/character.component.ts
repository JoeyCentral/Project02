import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-character',
  templateUrl: './character.component.html',
  styleUrls: ['./character.component.css']
})
export class CharacterComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  async save(){
    const container = {
    
    }
    const url = "http://localhost:8081/character/save";
    
    
    //await this.httpClient.post(url, container).toPromise();
  }

}

