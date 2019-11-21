import { Component, OnInit } from '@angular/core';
import { CharacterServiceService } from 'src/app/services/character-service.service';
import { Character } from 'src/app/models/character';

@Component({
  selector: 'app-character',
  templateUrl: './character.component.html',
  styleUrls: ['./character.component.css']
})
export class CharacterComponent implements OnInit {

  characters = <Character[]>;
  constructor(private characterService : CharacterServiceService) { }

  ngOnInit() {
  }

  async getCharater(){
    this.characters = await this.characterService.charService(1);
  }

  async updateCharacter(){
    //this.character.id = charId
  }
  

}
//character properties   
  // id = this.charNumber;
  // character_name:string;
  // player:User;
  // playerName:string
  // profile:Profile;
  // info:Info;
  // spellList:SpellList;

  //profile properties
  // id:number;
	// abilityScores:string;
	// inspiration:number;
	// alignmnet:string;
	// experience:number;
	// maximumHealth:number;
	// ac:number;
	// deathSaves:number;
	// hitDice:number;
	// currentHealth:number;
	// inventory:string;
	// languages:string;
	// race:Race;
	// background:Backgrounds;
	// proficiencies:[Proficiencies];
  // features:[Features];
  
  //spelllist properties
  // id:number;
	// castingFocus:string;
	// spellsLeft:number;
	// component:string;
	// spellsKnown:[Spells];
	// spellsAvilable:[Spells];
	// features:[Features];
