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

    console.log(this.loginService.userId);
    this.characterList = JSON.parse(JSON.stringify(data));
    const test = this.characterList[1];
  };

  async selectCharacter(c : Character) {
    console.log(c.id);
    this.characterService.character = await this.characterService.getMyCharacter(c.id)[0];
    
          console.log(c);
          console.log(this.characterService.character)
          this.router.navigateByUrl("/profile");
          // Tried to reroute to profile/{char ID}. Able to click on character on character page and retrieve character ID.


    // const charChecker = 
    //   setInterval(()=>{
    //     if (this.characterService.character) {
    //       console.log(c);
    //       console.log(this.characterService.character)
    //       this.router.navigateByUrl("/profile");
    //       clearInterval(charChecker);
    //     }
    //   }, 100);

  }
}
