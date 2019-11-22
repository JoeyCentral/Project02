import { Component, OnInit } from '@angular/core';
import { CharacterService } from 'src/app/services/character-service.service';
import { Character } from 'src/app/models/character';
import { HttpClient } from '@angular/common/http';
import { LoginService } from 'src/app/services/login-service.service';

@Component({
  selector: 'app-character',
  templateUrl: './character.component.html',
  styleUrls: ['./character.component.css']
})
export class CharacterComponent implements OnInit {

  characterList= [Character];

  constructor(private httpClient: HttpClient, private characterService : CharacterService, private loginService : LoginService) { }
  player=this.loginService.playername;
  ngOnInit() {
    this.getCharactersHttp();
  }
  async getCharactersHttp() {
  const url = 'http://localhost:8081/character/view/'+this.loginService.userId;
  const data = await this.httpClient.get(url).toPromise();
  console.log(data);
  this.characterList=JSON.parse(JSON.stringify(data));
};
}
