import { Component, OnInit } from '@angular/core';
import { HostListener } from "@angular/core";
import { CharacterService } from 'src/app/services/character-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})
export class InfoComponent implements OnInit {
  screenWidth: number;
  Header="HeaderNarrow";
  WidthControl="Narrow";
  MaxWidth="MNarrow";
  DoubleColumn = "col-md-12 m-0 p-0 mx-auto";
  SingleColumn = "col-md-12 m-0 p-0 mx-auto";
  constructor(private charServe: CharacterService, private router: Router) {this.getScreenSize}
  Age = this.charServe.character.info.age;
  Charname = this.charServe.character.character_name;
  Skin = this.charServe.character.info.skin;
  Hair = this.charServe.character.info.hair;
  Eyes = this.charServe.character.info.eyes;
  Height = this.charServe.character.info.height;
  Weight = this.charServe.character.info.weight;
  Personality = this.charServe.character.info.personality;
  Bonds = this.charServe.character.info.bonds;
  Backstory = this.charServe.character.info.backstory;
  Ideals = this.charServe.character.info.ideals;
  Flaws = this.charServe.character.info.flaws;
  Allies = this.charServe.character.info.alliance;
  //Symbol = this.charServe.character.info.symbol;
  //Picture = this.charServe.character.info.image;

  ngOnInit() {this.getScreenSize()
  }
  @HostListener('window:resize', ['$event'])
  getScreenSize(event?) {
        this.screenWidth = window.innerWidth;
        if (this.screenWidth>=1200){
          this.Header="HeaderWide";
          this.DoubleColumn="col-md-8 m-0 p-0 mx-auto";
          this.SingleColumn = "col-md-4 m-0 p-0 mx-auto";
          this.WidthControl="Wide";
          this.MaxWidth="MMiddle";
        } else if (this.screenWidth<=800){
          this.Header="HeaderNarrow";
          this.DoubleColumn="col-md-12 m-0 p-0 mx-auto";
          this.SingleColumn = "col-md-12 m-0 p-0 mx-auto";
          this.WidthControl="Narrow";
          this.MaxWidth="MNarrow";
        } else {
          this.Header="HeaderMiddle";
          this.DoubleColumn="col-md-6 m-0 p-0 mx-auto";
          this.SingleColumn = "col-md-6 m-0 p-0 mx-auto";
          this.WidthControl="Middle";
          this.MaxWidth="MMiddle";
        }
  }
  Save(){
    this.charServe.character.character_name=this.Charname;
    this.charServe.character.info={age:this.Age, alliance: this.Allies, backstory:this.Backstory, bonds:this.Bonds, eyes:this.Eyes, 
      id:this.charServe.character.info.id, flaws:this.Flaws, height:this.Height, ideals: this.Ideals, image: this.charServe.character.info.image, 
      personality:this.Personality, symbol:this.charServe.character.info.symbol, weight:this.Weight, hair:this.Hair, skin:this.Skin};
  }

  async SaveAndExit(){
    this.charServe.character.character_name=this.Charname;
    this.charServe.character.info={age:this.Age, alliance: this.Allies, backstory:this.Backstory, bonds:this.Bonds, eyes:this.Eyes, 
id:this.charServe.character.info.id, flaws:this.Flaws, height:this.Height, ideals: this.Ideals, image: this.charServe.character.info.image, 
personality:this.Personality, symbol:this.charServe.character.info.symbol, weight:this.Weight, hair:this.Hair, skin:this.Skin}
    let x = await this.charServe.saveCharacterHttp(this.charServe.character);
    this.router.navigateByUrl("/character");
  }
  async SaveToDatabase(){
    this.charServe.character.character_name=this.Charname;
    this.charServe.character.info={age:this.Age, alliance: this.Allies, backstory:this.Backstory, bonds:this.Bonds, eyes:this.Eyes, 
      id:this.charServe.character.info.id, flaws:this.Flaws, height:this.Height, ideals: this.Ideals, image: this.charServe.character.info.image, 
      personality:this.Personality, symbol:this.charServe.character.info.symbol, weight:this.Weight, hair:this.Hair, skin:this.Skin}
    let x = await this.charServe.saveCharacterHttp(this.charServe.character);
  }
  Exit(){
    this.router.navigateByUrl("/character");
  }
  async Copy(){
    this.charServe.character.character_name=this.Charname;
    this.charServe.character.info={age:this.Age, alliance: this.Allies, backstory:this.Backstory, bonds:this.Bonds, eyes:this.Eyes, 
      id:this.charServe.character.info.id, flaws:this.Flaws, height:this.Height, ideals: this.Ideals, image: this.charServe.character.info.image, 
      personality:this.Personality, symbol:this.charServe.character.info.symbol, weight:this.Weight, hair:this.Hair, skin:this.Skin}
    let x = await this.charServe.copyCharacterHttp(this.charServe.character);
  }
  async Share(){
    this.charServe.character.character_name=this.Charname;
    this.charServe.character.info={age:this.Age, alliance: this.Allies, backstory:this.Backstory, bonds:this.Bonds, eyes:this.Eyes, 
      id:this.charServe.character.info.id, flaws:this.Flaws, height:this.Height, ideals: this.Ideals, image: this.charServe.character.info.image, 
      personality:this.Personality, symbol:this.charServe.character.info.symbol, weight:this.Weight, hair:this.Hair, skin:this.Skin}
    let Shared = this.charServe.character;
    let x = await this.charServe.shareCharacterHttp(Shared);
  }
  async Delete(){
    await this.charServe.deleteCharacterHttp(this.charServe.character.id);
  }
}
