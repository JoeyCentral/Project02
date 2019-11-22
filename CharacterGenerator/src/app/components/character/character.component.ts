import { Component, OnInit } from '@angular/core';
import { CharacterService } from 'src/app/services/character-service.service';
import { Character } from 'src/app/models/character';
import { HttpClient } from '@angular/common/http';
import { LoginService } from 'src/app/services/login-service.service';
import { Multiclass } from 'src/app/models/multiclass';
import { Router } from '@angular/router';



@Component({
  selector: 'app-character',
  templateUrl: './character.component.html',
  styleUrls: ['./character.component.css']
})
export class CharacterComponent implements OnInit {

  characterList: Character[];

  constructor(private httpClient: HttpClient, private characterService: CharacterService, private loginService: LoginService,
    private router: Router) { }
  player = this.loginService.playername;
  ClassList: Multiclass[];
  Classes = "";



  ngOnInit() {
    this.getCharactersHttp();
  }
  async getCharactersHttp() {
    const url = `http://localhost:8081/character/view/${this.loginService.userId}`;
    const data = await this.httpClient.get(url).toPromise();
    this.characterList = JSON.parse(JSON.stringify(data));
  };

  async selectCharacter(c : Character) {
    const url = `http://localhost:8081/character/select/${c.id}`;
    console.log(c.id);
    const data = await this.httpClient.get(url).toPromise();
    this.characterService.character = JSON.parse(JSON.stringify(data));
          console.log(c);
          console.log(this.characterService.character)
          this.router.navigateByUrl("/profile");
  }
}
