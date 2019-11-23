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

  async selectCharacter(c: Character) {
    const url = `http://localhost:8081/character/select/${c.id}`;
    const data = await this.httpClient.get(url).toPromise();
    this.characterService.character = JSON.parse(JSON.stringify(data));
    this.router.navigateByUrl("/profile");
  };
  newCharacter() {
    this.characterService.character = {
      character_name: "", profile: {
        abilityScores: "101010101010", id: 0, ac: 10, maximumHealth: 0, currentHealth: 0, languages: "", inventory: "",
        tempHP: 0, race: {id:16,raceName:"Select Race", description:"", features:null}, experience: 0, features: null, 
        hitDice: "0000000000000000", inspiration: 0, proficiencies: null, roll: null, alignment: "",
        deathSaves: 0, background: {id:13,background_name:"Select Background", description:""}
      }, id: 0, spellList: null, multiclass: [{ level: 1, charClass: null, id: 0 }], player: {
        id: this.loginService.userId,
        password: "", username: this.loginService.playername
      }, playerName: this.loginService.playername, info: {
        backstory: "", id: 0, age: 0, alliance: "",
        bonds: "", flaws: "", hair: "", height: 0, ideals: "", image: "", personality: "", skin: "", symbol: "", weight: 0, eyes:""
      }
    }
    this.router.navigateByUrl("/profile");
  }
  logout() {
    this.loginService.userId=0;
    this.loginService.authenticated=false;
    this.loginService.playername="";
    this.router.navigateByUrl("/login");
  }
}
