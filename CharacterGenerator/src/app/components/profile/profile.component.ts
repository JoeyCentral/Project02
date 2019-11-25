import { Component, OnInit } from '@angular/core';
import { HostListener } from "@angular/core";
import { CharacterService } from 'src/app/services/character-service.service';
import { Router } from '@angular/router';
import { Multiclass } from 'src/app/models/multiclass';
import { Features } from 'src/app/models/features';
import { Race } from 'src/app/models/race';
import { Backgrounds } from 'src/app/models/backgrounds';
import { CharClass } from 'src/app/models/charclass';
import { Proficiencies } from 'src/app/models/proficiencies';

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
  Experiance = this.charServe.character.profile.experience;
  AC = this.charServe.character.profile.ac;
  MaximumHP = this.charServe.character.profile.maximumHealth;
  CurrentHP = this.charServe.character.profile.currentHealth;
  Languages = this.charServe.character.profile.languages;
  Player = this.charServe.character.player.username;
  Gear = this.charServe.character.profile.inventory;
  TemporaryHP = this.charServe.character.profile.tempHP;
  Classes = this.charServe.character.multiclass;
  Levelcount = this.countLevel(this.Classes);
  HaveBarb = false; HaveBard = false; HaveCleric = false; HaveDru = false; HaveFght = false; HavePal = false;
  HaveMonk = false; HaveRang = false; HaveRog = false; HaveSor = false; HaveWis = false; HaveWar = false;
  ClassList:CharClass[] = [
    {id:1, classname:"Barbarian", hit_die:12, features:[{ feat_name: "Example Barbarian Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }]}, 
    {id:2, classname:"Bard", hit_die:8, features:[{ feat_name: "Example Bard Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }]}, 
    {id:3, classname:"Cleric", hit_die:8, features:[{ feat_name: "Example Cleric Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }]}, 
    {id:4, classname:"Druid", hit_die:8, features:[{ feat_name: "Example Druid Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }]}, 
    {id:5, classname:"Fighter", hit_die:10, features:[{ feat_name: "Example Fighter Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }]}, 
    {id:6, classname:"Paladin", hit_die:10, features:[{ feat_name: "Example Paladin Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }]}, 
    {id:7, classname:"Monk", hit_die:8, features:[{ feat_name: "Example Monk Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }]}, 
    {id:8, classname:"Ranger", hit_die:10, features:[{ feat_name: "Example Ranger Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }]}, 
    {id:9, classname:"Rogue", hit_die:12, features:[{ feat_name: "Example Rogue Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }]}, 
    {id:10, classname:"Sorcerer", hit_die:6, features:[{ feat_name: "Example Sorcerer Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }]}, 
    {id:11, classname:"Warlock", hit_die:8, features:[{ feat_name: "Example Warlock Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }]}, 
    {id:12, classname:"Wizard", hit_die:6, features:[{ feat_name: "Example Wizard Feat", field_modified: "", id: 0, modifier: 0, prereq: "", reqval: 0 }]}
  ];
  Alignment = this.charServe.character.profile.alignment;
  Race = this.charServe.character.profile.race;
  Racenamed = this.Race.racename;
  Background = this.charServe.character.profile.background;
  Backgroundname = this.Background.background_name;
  Abilities = this.charServe.character.profile.abilityScores;
  SelectedClass = 0;
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
    BackgroundDisplay: Backgrounds[] = [
      { id: 1, description: "You were raised in a church.", background_name: "Acolyte"},
      { id: 2, description: "You made a living tricking and stealing from people.", background_name: "Charlitan"},
      { id: 3, description: "You made a living breaking the law.", background_name: "Criminal"},
      { id: 4, description: "You performed for others.", background_name: "Entertainer"},
      { id: 5, description: "You were a champion of common people.", background_name: "Folk Hero"},
      { id: 6, description: "You were a member of a guild.", background_name: "Guild Artisan"},
      { id: 7, description: "You lived alone.", background_name: "Hermit"},
      { id: 8, description: "You were raised in a wealthy family.", background_name: "Noble"},
      { id: 9, description: "You grew up near the wild.", background_name: "Outlander"},
      { id: 10, description: "You lived as a collector of knowledge.", background_name: "Sage"},
      { id: 11, description: "You grew up on the sea.", background_name: "Sailor"},
      { id: 12, description: "You were in an army.", background_name: "Soldier"},
      { id: 13, description: "You grew up poor in a city.", background_name: "Urchin"},
    ];
    Proficiencies = this.charServe.character.profile.proficiencies;
    Prof1 = "TProfNo";
    Prof2 = "ProfNo";
    Prof3 = "ProfNo";
    Prof4 = "HProfNo";
    Prof5 = "ProfNo";
    Prof6 = "ProfNo";
    Prof7 = "MProfNo";
    Prof8 = "ProfNo";
    Prof9 = "ProfNo";
    Prof10 = "ProfNo";
    Prof11 = "HProfNo";
    Prof12 = "ProfNo";
    Prof13 = "HProfNo";
    Prof14 = "HProfNo";
    Prof15 = "HProfNo";
    Prof16 = "ProfNo";
    Prof17 = "HProfNo";
    Prof18 = "ProfNo";
    Prof19 = "HProfNo";
    Prof20 = "ProfNo";
    Prof21 = "HProfNo";
    Prof22 = "ProfNo";
    Prof23 = "HProfNo";
    Prof24 = "ProfNo";
P1=0;P2=0;P3=0;P4=0;P5=0;P6=0;P7=0;P8=0;P9=0;P10=0;P11=0;P12=0;P13=0;P14=0;P15=0;P16=0;P17=0;P18=0;P19=0;P20=0;P21=0;P22=0;P23=0;P24=0;



  ngOnInit() {
    this.getScreenSize();
    this.SetProfs(this.Proficiencies);
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
  setBackground(background: Backgrounds) {
    this.Backgroundname = background.background_name;
    this.Background = background;
    document.getElementById('id03').style.display = 'none';
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
  SortClasses(){
    let i=0;
    let Remove:number[] = [];
    this.Classes.forEach(classitem => {
      switch(classitem.charClass.id){
      case 1: {this.HaveBarb = true;break;}
      case 2: {this.HaveBard = true;break;}
      case 3: {this.HaveCleric = true;break;}
      case 4: {this.HaveDru = true;break;}
      case 5: {this.HaveFght = true;break;}
      case 6: {this.HaveMonk = true;break;}
      case 7: {this.HavePal = true;break;}
      case 8: {this.HaveRang = true;break;}
      case 9: {this.HaveRog = true;break;}
      case 10: {this.HaveSor = true;break;}
      case 11: {this.HaveWar = true;break;}
      case 12: {this.HaveWis = true;break;}}
      //if (classitem.level<=0) {i++, Remove.push(i)};
    });
    //Remove.forEach(i => {
    //  this.Classes.splice(i,1);
    //});
  }

  AddClass(){
    let x = this.SelectedClass;
    let Classitem = this.ClassList[x]
    this.Classes.push({id:0, level:1, charClass:Classitem})
    if (this.Classes[0].id=0){this.Classes.splice(0,1)}
    this.SortClasses();
    this.Levelcount=this.countLevel(this.Classes)
  }

  LevelUp(myClass:Multiclass){
    this.Classes.forEach(Class => {
      if (Class.id==myClass.id) Class.level +=1;
      this.Levelcount=this.countLevel(this.Classes)
    });
  }

  LevelDown(myClass:Multiclass){
    this.Classes.forEach(Class => {
      if (Class.id==myClass.id) Class.level -=1;
      this.Levelcount=this.countLevel(this.Classes)
    });
  }
  countLevel(Classes:Multiclass[]):number{
  var totalLevel = 0;
  for (let multiclass of Classes) {
    totalLevel += multiclass.level;
  }
  return totalLevel;
}

  toggleProf(Prof:string, ID:number){
    switch(Prof){
    case "TProfYes": {Prof="TProfNo";break;}
    case "TProfNo": {Prof="TProfYes";break;}
    case "ProfYes": {Prof="ProfNo";break;}
    case "ProfNo": {Prof="ProfYes";break;}
    case "HProfYes": {Prof="HProfNo";break;}
    case "HProfNo": {Prof="HProfYes";break;}
    case "MProfYes": {Prof="MProfNo";break;}
    case "MProfNo": {Prof="MProfYes";break;}
    }
    switch(ID){
      case 1: {this.Prof1 = Prof;break;}
      case 2: {this.Prof2 = Prof;break;}
      case 3: {this.Prof3 = Prof;break;}
      case 4: {this.Prof4 = Prof;break;}
      case 5: {this.Prof5 = Prof;break;}
      case 6: {this.Prof6 = Prof;break;}
      case 7: {this.Prof7 = Prof;break;}
      case 8: {this.Prof8 = Prof;break;}
      case 9: {this.Prof9 = Prof;break;}
      case 10: {this.Prof10 = Prof;break;}
      case 11: {this.Prof11 = Prof;break;}
      case 12: {this.Prof12 = Prof;break;}
      case 13: {this.Prof13 = Prof;break;}
      case 14: {this.Prof14 = Prof;break;}
      case 15: {this.Prof15 = Prof;break;}
      case 16: {this.Prof16 = Prof;break;}
      case 17: {this.Prof17 = Prof;break;}
      case 18: {this.Prof18 = Prof;break;}
      case 19: {this.Prof19 = Prof;break;}
      case 20: {this.Prof20 = Prof;break;}
      case 21: {this.Prof21 = Prof;break;}
      case 22: {this.Prof22 = Prof;break;}
      case 23: {this.Prof23 = Prof;break;}
      case 24: {this.Prof24 = Prof;break;}
    };
    this.GetProfs();
  }

  SetProfs(Profs:Proficiencies[]){
    Profs.forEach(Profitem => {
      switch(Profitem.id){
        case 1: {this.Prof1 = "TProfYes";break;}
        case 2: {this.Prof2 = "ProfYes";break;}
        case 3: {this.Prof3 = "ProfYes";break;}
        case 4: {this.Prof4 = "HProfYes";break;}
        case 5: {this.Prof5 = "ProfYes";break;}
        case 6: {this.Prof6 = "ProfYes";break;}
        case 7: {this.Prof7 = "MProfYes";break;}
        case 8: {this.Prof8 = "ProfYes";break;}
        case 9: {this.Prof9 = "ProfYes";break;}
        case 10: {this.Prof10 = "ProfYes";break;}
        case 11: {this.Prof11 = "HProfYes";break;}
        case 12: {this.Prof12 = "ProfYes";break;}
        case 13: {this.Prof13 = "HProfYes";break;}
        case 14: {this.Prof14 = "HProfYes";break;}
        case 15: {this.Prof15 = "HProfYes";break;}
        case 16: {this.Prof16 = "ProfYes";break;}
        case 17: {this.Prof17 = "HProfYes";break;}
        case 18: {this.Prof18 = "ProfYes";break;}
        case 19: {this.Prof19 = "HProfYes";break;}
        case 20: {this.Prof20 = "ProfYes";break;}
        case 21: {this.Prof21 = "HProfYes";break;}
        case 22: {this.Prof22 = "ProfYes";break;}
        case 23: {this.Prof23 = "HProfYes";break;}
        case 24: {this.Prof24 = "ProfYes";break;}
        this.GetProfs();
      };
    });
  }

  GetProfs(){
  /*  if (this.Prof1 = "TProfYes") {this.P1 = this.ProfBonus + Math.floor((this.Str-10)/2)} else {this.P1 = Math.floor((this.Str-10)/2)};
    if (this.Prof2 = "TProfYes") {this.P2 = this.ProfBonus + Math.floor((this.Dex-10)/2)} else {this.P2 = Math.floor((this.Dex-10)/2)};
    if (this.Prof3 = "TProfYes") {this.P3 = this.ProfBonus + Math.floor((this.Con-10)/2)} else {this.P3 = Math.floor((this.Con-10)/2)};
    if (this.Prof4 = "TProfYes") {this.P4 = this.ProfBonus + Math.floor((this.Int-10)/2)} else {this.P4 = Math.floor((this.Int-10)/2)};
    if (this.Prof5 = "TProfYes") {this.P5 = this.ProfBonus + Math.floor((this.Wis-10)/2)} else {this.P5 = Math.floor((this.Wis-10)/2)};
    if (this.Prof6 = "TProfYes") {this.P6 = this.ProfBonus + Math.floor((this.Chr-10)/2)} else {this.P6 = Math.floor((this.Chr-10)/2)};
    if (this.Prof7 = "TProfYes") {this.P7 = this.ProfBonus + Math.floor((this.Dex-10)/2)} else {this.P7 = Math.floor((this.Dex-10)/2)};
    if (this.Prof8 = "TProfYes") {this.P8 = this.ProfBonus + Math.floor((this.Wis-10)/2)} else {this.P8 = Math.floor((this.Wis-10)/2)};
    if (this.Prof9 = "TProfYes") {this.P9 = this.ProfBonus + Math.floor((this.Int-10)/2)} else {this.P9 = Math.floor((this.Int-10)/2)};
    if (this.Prof10 = "TProfYes") {this.P10 = this.ProfBonus + Math.floor((this.Str-10)/2)} else {this.P10 = Math.floor((this.Str-10)/2)};
    if (this.Prof11 = "TProfYes") {this.P11 = this.ProfBonus + Math.floor((this.Chr-10)/2)} else {this.P11 = Math.floor((this.Chr-10)/2)};
    if (this.Prof12 = "TProfYes") {this.P12 = this.ProfBonus + Math.floor((this.Int-10)/2)} else {this.P12 = Math.floor((this.Int-10)/2)};
    if (this.Prof13 = "TProfYes") {this.P13 = this.ProfBonus + Math.floor((this.Wis-10)/2)} else {this.P13 = Math.floor((this.Wis-10)/2)};
    if (this.Prof14 = "TProfYes") {this.P14 = this.ProfBonus + Math.floor((this.Chr-10)/2)} else {this.P14 = Math.floor((this.Chr-10)/2)};
    if (this.Prof15 = "TProfYes") {this.P15 = this.ProfBonus + Math.floor((this.Int-10)/2)} else {this.P15 = Math.floor((this.Int-10)/2)};
    if (this.Prof16 = "TProfYes") {this.P16 = this.ProfBonus + Math.floor((this.Wis-10)/2)} else {this.P16 = Math.floor((this.Wis-10)/2)};
    if (this.Prof17 = "TProfYes") {this.P17 = this.ProfBonus + Math.floor((this.Int-10)/2)} else {this.P17 = Math.floor((this.Int-10)/2)};
    if (this.Prof18 = "TProfYes") {this.P18 = this.ProfBonus + Math.floor((this.Wis-10)/2)} else {this.P18 = Math.floor((this.Wis-10)/2)};
    if (this.Prof19 = "TProfYes") {this.P19 = this.ProfBonus + Math.floor((this.Chr-10)/2)} else {this.P19 = Math.floor((this.Chr-10)/2)};
    if (this.Prof20 = "TProfYes") {this.P20 = this.ProfBonus + Math.floor((this.Chr-10)/2)} else {this.P20 = Math.floor((this.Chr-10)/2)};
    if (this.Prof21 = "TProfYes") {this.P21 = this.ProfBonus + Math.floor((this.Int-10)/2)} else {this.P21 = Math.floor((this.Int-10)/2)};
    if (this.Prof22 = "TProfYes") {this.P22 = this.ProfBonus + Math.floor((this.Dex-10)/2)} else {this.P22 = Math.floor((this.Dex-10)/2)};
    if (this.Prof23 = "TProfYes") {this.P23 = this.ProfBonus + Math.floor((this.Dex-10)/2)} else {this.P23 = Math.floor((this.Dex-10)/2)};
    if (this.Prof24 = "TProfYes") {this.P24 = this.ProfBonus + Math.floor((this.Wis-10)/2)} else {this.P24 = Math.floor((this.Wis-10)/2)};*/
  }

  Save() {
    this.charServe.character.character_name = this.Charname;
    this.charServe.character.profile = {abilityScores: (""+this.Str+this.Dex+this.Con+this.Int+this.Wis+this.Chr), ac:this.AC, 
    alignment: this.Alignment, background:this.Background, currentHealth:this.CurrentHP, 
    deathSaves:(this.DeathPass*10+this.DeathFail), experience:this.Experiance, features:this.CustomFeatures, hitDice:"", 
    id:this.charServe.character.profile.id, inspiration:this.charServe.character.profile.inspiration,
    inventory:this.Gear, languages:this.Languages, maximumHealth:this.MaximumHP, proficiencies:this.Proficiencies, race:this.Race, roll:this.Attack,
    tempHP: this.TemporaryHP, vision: this.Vision, speed:this.Speed};
    this.charServe.character.multiclass=this.Classes;
    console.log(this.charServe.character)
  }

  async SaveAndExit() {
    this.charServe.character.character_name = this.Charname;
    this.charServe.character.profile = {abilityScores: (""+this.Str+this.Dex+this.Con+this.Int+this.Wis+this.Chr), ac:this.AC, 
    alignment: this.Alignment, background:this.Background, currentHealth:this.CurrentHP, 
    deathSaves:(this.DeathPass*10+this.DeathFail), experience:this.Experiance, features:this.CustomFeatures, hitDice:"", 
    id:this.charServe.character.profile.id, inspiration:this.charServe.character.profile.inspiration,
    inventory:this.Gear, languages:this.Languages, maximumHealth:this.MaximumHP, proficiencies:this.Proficiencies, race:this.Race, roll:this.Attack,
    tempHP: this.TemporaryHP, vision: this.Vision, speed:this.Speed};
    this.charServe.character.multiclass=this.Classes;
    let x = await this.charServe.saveCharacterHttp(this.charServe.character);
    this.router.navigateByUrl("/character");
  }
  async SaveToDatabase() {
    this.charServe.character.character_name = this.Charname;
    this.charServe.character.profile = {abilityScores: (""+this.Str+this.Dex+this.Con+this.Int+this.Wis+this.Chr), ac:this.AC, 
    alignment: this.Alignment, background:this.Background, currentHealth:this.CurrentHP, 
    deathSaves:(this.DeathPass*10+this.DeathFail), experience:this.Experiance, features:this.CustomFeatures, hitDice:"", 
    id:this.charServe.character.profile.id, inspiration:this.charServe.character.profile.inspiration,
    inventory:this.Gear, languages:this.Languages, maximumHealth:this.MaximumHP, proficiencies:this.Proficiencies, race:this.Race, roll:this.Attack,
    tempHP: this.TemporaryHP, vision: this.Vision, speed:this.Speed};
    this.charServe.character.multiclass=this.Classes;
    let x = await this.charServe.saveCharacterHttp(this.charServe.character);
  }
  Exit() {
    this.router.navigateByUrl("/character");
  }
  async Copy() {
    this.charServe.character.character_name = this.Charname;
    this.charServe.character.profile = {abilityScores: (""+this.Str+this.Dex+this.Con+this.Int+this.Wis+this.Chr), ac:this.AC, 
    alignment: this.Alignment, background:this.Background, currentHealth:this.CurrentHP, 
    deathSaves:(this.DeathPass*10+this.DeathFail), experience:this.Experiance, features:this.CustomFeatures, hitDice:"", 
    id:this.charServe.character.profile.id, inspiration:this.charServe.character.profile.inspiration,
    inventory:this.Gear, languages:this.Languages, maximumHealth:this.MaximumHP, proficiencies:this.Proficiencies, race:this.Race, roll:this.Attack,
    tempHP: this.TemporaryHP, vision: this.Vision, speed:this.Speed};
    this.charServe.character.multiclass=this.Classes;
    let x = await this.charServe.copyCharacterHttp(this.charServe.character);
  }
  async Share() {
    this.charServe.character.character_name = this.Charname;
    this.charServe.character.profile = {abilityScores: (""+this.Str+this.Dex+this.Con+this.Int+this.Wis+this.Chr), ac:this.AC, 
    alignment: this.Alignment, background:this.Background, currentHealth:this.CurrentHP, 
    deathSaves:(this.DeathPass*10+this.DeathFail), experience:this.Experiance, features:this.CustomFeatures, hitDice:"", 
    id:this.charServe.character.profile.id, inspiration:this.charServe.character.profile.inspiration,
    inventory:this.Gear, languages:this.Languages, maximumHealth:this.MaximumHP, proficiencies:this.Proficiencies, race:this.Race, roll:this.Attack,
    tempHP: this.TemporaryHP, vision: this.Vision, speed:this.Speed};
    this.charServe.character.multiclass=this.Classes;
    let Shared = this.charServe.character;
    let x = await this.charServe.shareCharacterHttp(Shared);
  }
  async Delete() {
    await this.charServe.deleteCharacterHttp(this.charServe.character.id);
  }
}