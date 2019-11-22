import { Component, OnInit } from '@angular/core';
import { HostListener } from "@angular/core";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  screenWidth: number;
  Header="HeaderNarrow";
  WidthControl="Narrow";
  MaxWidth="MNarrow";
  DoubleColumn = "col-md-12 m-0 p-0 mx-auto";
  SingleColumn = "col-md-12 m-0 p-0 mx-auto";
  constructor() { this.getScreenSize}
  CharClass = "Barbarian";
  Charname = "Freddy";
  Level = 3;
  Player = "Critesk";
  Background = "Select Background";
  Race = "";
  Alignment = "";
  Languages = "This is a demonstration of how the language box expands when sufficient lines are contained to require expantion. The base size will be three lines, but will expand to as much as needed. This principle will be applied to every text diplay area.";
  Gear = "This is a demonstration of how the gear box expands when sufficient lines are contained to require expantion. The base size will be three lines, but will expand to as much as needed. This principle will be applied to every text diplay area.";
  Features = "This is a demonstration of how the feature box expands when sufficient lines are contained to require expantion. The base size will be three lines, but will expand to as much as needed. This principle will be applied to every text diplay area.";
  Attacks = "";
  ProfBonus = Math.ceil((this.Level/4)+1);
  Inspiration = ""; Passive = 15;
  Prof1 = "TProfYes";Prof2 = "ProfYes";Prof3 = "ProfYes";Prof4 = "HProfYes";Prof5 = "ProfYes";Prof6 = "ProfYes";
  Prof7 = "MProfYes";Prof8 = "ProfYes";Prof9 = "ProfYes";Prof10 = "ProfYes";Prof11 = "HProfYes";Prof12 = "ProfYes";
  Prof13 = "HProfYes";Prof14 = "HProfYes";Prof15 = "HProfYes";Prof16 = "ProfYes";Prof17 = "HProfYes";Prof18 = "ProfYes";
  Prof19 = "HProfYes";Prof20 = "ProfYes";Prof21 = "HProfYes";Prof22 = "ProfYes";Prof23 = "HProfYes";Prof24 = "ProfYes";
  P1=1;P2=2;P3=3;P4=4;P5=5;P6=6;P7=7;P8=8;P9=9;P10=10;P11=11;P12=12;P13=13;P14=14;P15=15;P16=16;P17=17;P18=18;P19=19;P20=20;P21=21;P22=22;P23=23;P24=24;

  AC=10;MaximumHP=20;CurrentHP=10;TemporaryHP=0;
  Initiative=2;Speed=30;Vision=60;
  HitSix=0; HitEight=0; HitTen=1; HitTwelve=0;
  DiceSix=0; DiceEight=0; DiceTen=1; DiceTwelve=0;
  DeathPass="3";DeathFail="3";


  races=[{name:"Elf"}, {name:"Dwarf"}, {name:"Human"}];
  aligns=[{name:"Lawful Good"}, {name:"Lawful Neutral"}, {name:"Lawful Evil"}];
  backgrounds=[{name:"Acolyte"}, {name:"Criminal"}, {name:"Entertainer"}];
  Str=10;Dex=10;Con=10;Int=10;Wis=10;Chr=10;


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
}

/*
import { Component, OnInit } from '@angular/core';
import { HostListener } from "@angular/core";
import { CharacterService } from '../../services/character-service.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  screenWidth: number;
  Header="HeaderNarrow";
  WidthControl="Narrow";
  MaxWidth="MNarrow";
  DoubleColumn = "col-md-12 m-0 p-0 mx-auto";
  SingleColumn = "col-md-12 m-0 p-0 mx-auto";
  constructor(private charServe: CharacterService) { this.getScreenSize}
  AC=this.charServe.character.profile.ac;
  MaximumHP=this.charServe.character.profile.maximumHealth;
  CurrentHP=this.charServe.character.profile.currentHealth;
  Languages = this.charServe.character.profile.languages;
  Player = this.charServe.character.player.username;
  Gear = this.charServe.character.profile.inventory;
  TemporaryHP=this.charServe.character.profile.tempHP;

  Inspiration = this.charServe.character.profile.inspiration; //if inspiration=0 then value = 0, if inspiration = 1 then inspiration=x where 'x'
  Alignment = this.charServe.character.profile.alignmnet; //number from 1 - 10, populate a drop down menu from an array of strings line 168 profile html
  Background = this.charServe.character.profile.background; // "
  Race = this.charServe.character.profile.race; // "
  Features = this.charServe.character.profile.features;//display array w ngFor
  CharClass = this.charServe.character.classes;//read from multiclass costom pipe
  Level = this.charServe.character.classes;//"
  Attacks = this.charServe.character.profile.roll;
  ProfBonus = Math.ceil((5/4)+1);// level should be a single number, the sum of all the levels in the multiclass array --> make a pipe
  Initiative=this.charServe.character.profile;Speed=30;Vision=60;// ambiguous custom pipe 

  Passive = 15;
  Prof1 = "TProfYes";Prof2 = "ProfYes";Prof3 = "ProfYes";Prof4 = "HProfYes";Prof5 = "ProfYes";Prof6 = "ProfYes"; // nested if id exists = yes else no
  Prof7 = "MProfYes";Prof8 = "ProfYes";Prof9 = "ProfYes";Prof10 = "ProfYes";Prof11 = "HProfYes";Prof12 = "ProfYes";
  Prof13 = "HProfYes";Prof14 = "HProfYes";Prof15 = "HProfYes";Prof16 = "ProfYes";Prof17 = "HProfYes";Prof18 = "ProfYes";
  Prof19 = "HProfYes";Prof20 = "ProfYes";Prof21 = "HProfYes";Prof22 = "ProfYes";Prof23 = "HProfYes";Prof24 = "ProfYes";
  P1=1;P2=2;P3=3;P4=4;P5=5;P6=6;P7=7;P8=8;P9=9;P10=10;P11=11;P12=12;P13=13;P14=14;P15=15;P16=16;P17=17;P18=18;P19=19;P20=20;P21=21;P22=22;P23=23;P24=24; // custom pipe to show prof number 

  
  HitSix=0; HitEight=0; HitTen=1; HitTwelve=0;//custom pipe to get dice number from larger number
  DiceSix=0; DiceEight=0; DiceTen=1; DiceTwelve=0;
  
  DeathPass="3";DeathFail="3";//pipe to get value from death saves


  races=[{name:"Elf"}, {name:"Dwarf"}, {name:"Human"}]; //should be an array of options
  aligns=[{name:"Lawful Good"}, {name:"Lawful Neutral"}, {name:"Lawful Evil"}];//"
  backgrounds=[{name:"Acolyte"}, {name:"Criminal"}, {name:"Entertainer"}];//"
  
  Str=10;Dex=10;Con=10;Int=10;Wis=10;Chr=10;//unpacked from this.charServe.character.profile.abilityScore


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
}
*/