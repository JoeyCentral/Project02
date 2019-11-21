import { Component, OnInit } from '@angular/core';
import { CharacterServiceService } from 'src/app/services/character-service.service';
import { Character } from 'src/app/models/character';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-character',
  templateUrl: './character.component.html',
  styleUrls: ['./character.component.css']
})
export class CharacterComponent implements OnInit {
  //screenWidth: number;
  //Header="Narrow";
  //constructor() { this.getScreenSize(); }

  characterList= <Character[]>[];

  //charactersForm : FormGroup;
  constructor(private characterService : CharacterServiceService
    ) { }

  ngOnInit() {
  }

 // this.charactersForm = this.formBuilder.group({
  //  character_name: '',
 // });
//  this.characterList = <Character>await this.characterService.getCharacters(1)
//  this.populateCharacterPage();




/**
populateCharacterPage() {
  let v = this.character;
  v.id = this.charactersForm.value['name'];
  v.character_name = this.charactersForm.value['vin'];
  v.player = this.charactersForm.value['year'];
  v.profile = this.charactersForm.value['make'];
  v.info = this.charactersForm.value['model'];
  v.spellList = this.charactersForm.value['color'];

  this.CharacterServiceService.populateCharacterPage(v).subscribe(
    () => console.log(v)
  );

  */

};
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
