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
  constructor() { this.getScreenSize}
  CharClass = "Barbarian";
  Level = 3;
  Player = "Critesk";
  Background = "Select Background";
  Race = "";
  Alignment = "";
  Test = "This is a Test";
  Languages = "This is a demonstration of how the language box expands when sufficient lines are contained to require expantion. The base size will be three lines, but will expand to as much as needed. This principle will be applied to every text diplay area.";
  ProfBonus = Math.ceil((this.Level/4)+1);
  Inspiration = ""; Passive = 15;
  Prof1 = "TProfYes";Prof2 = "ProfYes";Prof3 = "ProfYes";Prof4 = "HProfYes";Prof5 = "ProfYes";Prof6 = "ProfYes";
  Prof7 = "MProfYes";Prof8 = "ProfYes";Prof9 = "ProfYes";Prof10 = "ProfYes";Prof11 = "HProfYes";Prof12 = "ProfYes";
  Prof13 = "HProfYes";Prof14 = "HProfYes";Prof15 = "HProfYes";Prof16 = "ProfYes";Prof17 = "HProfYes";Prof18 = "ProfYes";
  Prof19 = "HProfYes";Prof20 = "ProfYes";Prof21 = "HProfYes";Prof22 = "ProfYes";Prof23 = "HProfYes";Prof24 = "ProfYes";
  P1=1;P2=2;P3=3;P4=4;P5=5;P6=6;P7=7;P8=8;P9=9;P10=10;P11=11;P12=12;P13=13;P14=14;P15=15;P16=16;P17=17;P18=18;P19=19;P20=20;P21=21;P22=22;P23=23;P24=24;
  DoubleColumn = "col-md-12 m-0 p-0 mx-auto";
  SingleColumn = "col-md-12 m-0 p-0 mx-auto";

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
        } else if (this.screenWidth<=800){
          this.Header="HeaderNarrow";
          this.DoubleColumn="col-md-12 m-0 p-0 mx-auto";
          this.SingleColumn = "col-md-12 m-0 p-0 mx-auto";
          this.WidthControl="Narrow";
        } else {
          this.Header="HeaderMiddle";
          this.DoubleColumn="col-md-6 m-0 p-0 mx-auto";
          this.SingleColumn = "col-md-6 m-0 p-0 mx-auto";
          this.WidthControl="Middle";
        }
  }
}
