import { Component, OnInit } from '@angular/core';
import { HostListener } from "@angular/core";
import { CharacterService } from 'src/app/services/character-service.service';
import { Router } from '@angular/router';
import { Multiclass } from 'src/app/models/multiclass';
import { Features } from 'src/app/models/features';
import { Race } from 'src/app/models/race';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  screenWidth: number;
  Header = "HeaderNarrow";
  WidthControl = "Narrow";
  MaxWidth = "MNarrow";
  DoubleColumn = "col-md-12 m-0 p-0 mx-auto";
  SingleColumn = "col-md-12 m-0 p-0 mx-auto";
  constructor(private charServe: CharacterService, private router: Router) { this.getScreenSize }
  Charname = this.charServe.character.character_name;
  AC = this.charServe.character.profile.ac;
  MaximumHP = this.charServe.character.profile.maximumHealth;
  CurrentHP = this.charServe.character.profile.currentHealth;
  Languages = this.charServe.character.profile.languages;
  Player = this.charServe.character.player.username;
  Gear = this.charServe.character.profile.inventory;
  TemporaryHP = this.charServe.character.profile.tempHP;
  Classes = this.charServe.character.multiclass;
  Alignment = this.charServe.character.profile.alignment;
  Race = this.charServe.character.profile.race;
  Racenamed = this.Race.racename;
  Background = this.charServe.character.profile.background.background_name;
  Abilities = this.charServe.character.profile.abilityScores;
  Str = Math.floor((+this.Abilities) / 10000000000);
  Dex = Math.floor((+this.Abilities) / 100000000) - this.Str * 100;
  Con = Math.floor((+this.Abilities) / 1000000) - this.Str * 10000 - this.Dex * 100;
  Int = Math.floor((+this.Abilities) / 10000) - this.Str * 1000000 - this.Dex * 10000 - this.Con * 100;
  Wis = Math.floor((+this.Abilities) / 100) - this.Str * 100000000 - this.Dex * 1000000 - this.Con * 10000 - this.Int * 100;
  Chr = +this.Abilities - this.Str * 10000000000 - this.Dex * 100000000 - this.Con * 1000000 - this.Int * 10000 - this.Wis * 100;
  Speed = this.charServe.character.profile.speed;
  ProfBonus = Math.ceil((this.Level(this.charServe.character.multiclass) / 4) + 1);
  Vision = this.charServe.character.profile.vision;
  Attack = this.charServe.character.profile.roll;
  ClassFeatures = this.ClassFeats(this.charServe.character.multiclass);
  RaceFeatures = this.charServe.character.profile.race.features;
  CustomFeatures = this.charServe.character.profile.features;
  Inspiration = this.Inspire(this.charServe.character.profile.inspiration);
  RaceDisplay: Race[] = [
    { id: 1, description: "This is a Hill Dwarf.", racename: "Hill Dwarf", features: [{ feat_name: "Example Dwarf Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }] },
    { id: 2, description: "This is a Mountain Dwarf.", racename: "Mountain Dwarf", features: [{ feat_name: "Example Dwarf Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }] },
    { id: 3, description: "This is a High Elf.", racename: "High Elf", features: [{ feat_name: "Example Elf Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }] },
    { id: 4, description: "This is a Wood Elf.", racename: "Wood Elf", features: [{ feat_name: "Example Elf Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }] },
    { id: 5, description: "This is a Drow.", racename: "Drow", features: [{ feat_name: "Example Elf Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }] },
    { id: 6, description: "This is a Lightfoot Halfing.", racename: "Lightfoot Halfing", features: [{ feat_name: "Example Halfling Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }] },
    { id: 7, description: "This is a Stout Halfing.", racename: "Stout Halfing", features: [{ feat_name: "Example Halfling Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }] },
    { id: 8, description: "This is a Human.", racename: "Human", features: [{ feat_name: "Example Human Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }] },
    { id: 9, description: "This is a variant Human.", racename: "Human (variant)", features: [{ feat_name: "Example Human Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }] },
    { id: 10, description: "This is a Dragonborn.", racename: "Dragonborn", features: [{ feat_name: "Example Dragonborn Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }] },
    { id: 11, description: "This is a Rock Gnome.", racename: "Rock Gnome", features: [{ feat_name: "Example Gnome Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }] },
    { id: 12, description: "This is a Forest Gnome.", racename: "Forest Gnome", features: [{ feat_name: "Example Gnome Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }] },
    { id: 13, description: "This is a Half-Elf.", racename: "Half-Elf", features: [{ feat_name: "Example Half-Elf Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }] },
    { id: 14, description: "This is a Half-Orc.", racename: "Half-Orc", features: [{ feat_name: "Example Half-Orc Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }] },
    { id: 15, description: "This is a Tiefling.", racename: "Tiefling", features: [{ feat_name: "Example Tiefling Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }] }];
    HitDice = this.charServe.character.profile.hitDice;
    HitSix=Math.floor((+this.HitDice) / 100000000000000); 
    HitEight=Math.floor((+this.HitDice) / 1000000000000) - this.HitSix*100;
    HitTen=Math.floor((+this.HitDice) / 10000000000)- this.HitSix*10000 - this.HitEight*100; 
    HitTwelve=Math.floor((+this.HitDice) / 100000000) - this.HitSix*1000000 - this.HitEight*10000 -this.HitTen*100;
    DiceSix=Math.floor((+this.HitDice) / 1000000)- this.HitSix*100000000 - this.HitEight*1000000 -this.HitTen*10000 -this.HitTwelve*100; 
    DiceEight=Math.floor((+this.HitDice) / 10000)- this.HitSix*10000000000 - this.HitEight*100000000 -this.HitTen*1000000
     -this.HitTwelve*10000 -this.DiceSix*100; 
    DiceTen=Math.floor((+this.HitDice) / 100)- this.HitSix*1000000000000 - this.HitEight*10000000000 -this.HitTen*100000000
    -this.HitTwelve*1000000 -this.DiceSix*10000 - this.DiceEight*100; 
    DiceTwelve=+this.HitDice- this.HitSix*100000000000000 - this.HitEight*1000000000000 -this.HitTen*10000000000
    -this.HitTwelve*100000000 -this.DiceSix*1000000 - this.DiceEight*10000 -this.DiceTen*100;
    DeathPass = Math.floor(this.charServe.character.profile.deathSaves/10);
    DeathFail = this.charServe.character.profile.deathSaves - this.DeathPass*10;
    AlignmentLawful: string[] = [
      "Lawful Good",
      "Lawful Neutral",
      "Lawful Evil",
    ];
  
    AlignmentNeutral: string[] = [
      "Neutral Good",
      "Neutral",
      "Neutral Evil"
    ];
  
    AlignmentChaotic: string[] = [
      "Chaotic Good",
      "Chaotic Neutral",
      "Chaotic Evil"
    ];

  /*
  Passive = 15;
  Prof1 = "TProfYes";Prof2 = "ProfYes";Prof3 = "ProfYes";Prof4 = "HProfYes";Prof5 = "ProfYes";Prof6 = "ProfYes"; // nested if id exists = yes else no
  Prof7 = "MProfYes";Prof8 = "ProfYes";Prof9 = "ProfYes";Prof10 = "ProfYes";Prof11 = "HProfYes";Prof12 = "ProfYes";
  Prof13 = "HProfYes";Prof14 = "HProfYes";Prof15 = "HProfYes";Prof16 = "ProfYes";Prof17 = "HProfYes";Prof18 = "ProfYes";
  Prof19 = "HProfYes";Prof20 = "ProfYes";Prof21 = "HProfYes";Prof22 = "ProfYes";Prof23 = "HProfYes";Prof24 = "ProfYes";
  P1=1;P2=2;P3=3;P4=4;P5=5;P6=6;P7=7;P8=8;P9=9;P10=10;P11=11;P12=12;P13=13;P14=14;P15=15;P16=16;P17=17;P18=18;P19=19;P20=20;P21=21;P22=22;P23=23;P24=24; // custom pipe to show prof number 
*/


  ngOnInit() {
    this.getScreenSize()
  }
  @HostListener('window:resize', ['$event'])
  getScreenSize(event?) {
    this.screenWidth = window.innerWidth;
    if (this.screenWidth >= 1200) {
      this.Header = "HeaderWide";
      this.DoubleColumn = "col-md-8 m-0 p-0 mx-auto";
      this.SingleColumn = "col-md-4 m-0 p-0 mx-auto";
      this.WidthControl = "Wide";
      this.MaxWidth = "MMiddle";
    } else if (this.screenWidth <= 800) {
      this.Header = "HeaderNarrow";
      this.DoubleColumn = "col-md-12 m-0 p-0 mx-auto";
      this.SingleColumn = "col-md-12 m-0 p-0 mx-auto";
      this.WidthControl = "Narrow";
      this.MaxWidth = "MNarrow";
    } else {
      this.Header = "HeaderMiddle";
      this.DoubleColumn = "col-md-6 m-0 p-0 mx-auto";
      this.SingleColumn = "col-md-6 m-0 p-0 mx-auto";
      this.WidthControl = "Middle";
      this.MaxWidth = "MMiddle";
    }
  }
  Level(x: Multiclass[]): number {
    var totalLevel = 0;
    for (let multiclass of x) {
      totalLevel += multiclass.level;
    }
    return totalLevel;
  }

  ClassFeats(x: Multiclass[]): Features[] {
    var allFeats: Features[];
    for (let multiclass of x) {
      if (multiclass.charClass.features.length != 0) {
        for (let feature of multiclass.charClass.features)
          allFeats.push(feature);
      }
    }
    return allFeats;
  }

  Inspire(x: number): string {
    if (x === 1) return "x";
    else return "";
  }
  Inspired(){
    this.charServe.character.profile.inspiration *=-1;
    this.Inspiration = this.Inspire(this.charServe.character.profile.inspiration);
  }

  setRace(race: Race) {
    this.Racenamed = race.racename;
    this.Race = race;
    this.RaceFeatures = race.features;
    document.getElementById('id02').style.display = 'none';
  }
  setAlignment(alignment: string) {
    this.Alignment = alignment;
    document.getElementById('id04').style.display = 'none';
  }

  DeathPassed(){
    if (this.DeathPass == 3){this.DeathPass = 0}
    else {this.DeathPass+=1}
  }
  DeathFailed(){
    if (this.DeathFail == 3){this.DeathFail = 0}
    else {this.DeathFail+=1}
  }


  Save() {
    this.charServe.character.character_name = this.Charname;
  //  this.charServe.character.profile = {abilityScores: "", ac:0, alignment: "", background:null,
  //  currentHealth:0, deathSaves:0, experience:0, features:null, hitDice:"", id:0, inspiration:0,
  //  inventory:"", languages:"", maximumHealth:0, proficiencies:null,  race:null, roll:null,
  //  tempHP: 0, vision: 0, speed:0}
  }

  async SaveAndExit() {
    this.charServe.character.character_name = this.Charname;
    /*   this.charServe.character.info={age:this.Age, alliance: this.Allies, backstory:this.Backstory, bonds:this.Bonds, eyes:this.Eyes, 
  id:this.charServe.character.info.id, flaws:this.Flaws, height:this.Height, ideals: this.Ideals, image: this.charServe.character.info.image, 
  personality:this.Personality, symbol:this.charServe.character.info.symbol, weight:this.Weight, hair:this.Hair, skin:this.Skin}*/
    let x = await this.charServe.saveCharacterHttp(this.charServe.character);
    this.router.navigateByUrl("/character");
  }
  async SaveToDatabase() {
    this.charServe.character.character_name = this.Charname;
    /*  this.charServe.character.info={age:this.Age, alliance: this.Allies, backstory:this.Backstory, bonds:this.Bonds, eyes:this.Eyes, 
       id:this.charServe.character.info.id, flaws:this.Flaws, height:this.Height, ideals: this.Ideals, image: this.charServe.character.info.image, 
       personality:this.Personality, symbol:this.charServe.character.info.symbol, weight:this.Weight, hair:this.Hair, skin:this.Skin}*/
    let x = await this.charServe.saveCharacterHttp(this.charServe.character);
  }
  Exit() {
    this.router.navigateByUrl("/character");
  }
  async Copy() {
    this.charServe.character.character_name = this.Charname;
    /*  this.charServe.character.info={age:this.Age, alliance: this.Allies, backstory:this.Backstory, bonds:this.Bonds, eyes:this.Eyes, 
       id:this.charServe.character.info.id, flaws:this.Flaws, height:this.Height, ideals: this.Ideals, image: this.charServe.character.info.image, 
       personality:this.Personality, symbol:this.charServe.character.info.symbol, weight:this.Weight, hair:this.Hair, skin:this.Skin}*/
    let x = await this.charServe.copyCharacterHttp(this.charServe.character);
  }
  async Share() {
    this.charServe.character.character_name = this.Charname;
    /*  this.charServe.character.info={age:this.Age, alliance: this.Allies, backstory:this.Backstory, bonds:this.Bonds, eyes:this.Eyes, 
       id:this.charServe.character.info.id, flaws:this.Flaws, height:this.Height, ideals: this.Ideals, image: this.charServe.character.info.image, 
       personality:this.Personality, symbol:this.charServe.character.info.symbol, weight:this.Weight, hair:this.Hair, skin:this.Skin}*/
    let Shared = this.charServe.character;
    let x = await this.charServe.shareCharacterHttp(Shared);
  }
  async Delete() {
    await this.charServe.deleteCharacterHttp(this.charServe.character.id);
  }
}