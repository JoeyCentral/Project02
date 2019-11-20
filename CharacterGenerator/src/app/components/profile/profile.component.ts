import { Component, OnInit } from '@angular/core';
import { HostListener } from "@angular/core";
import { CharacterServiceService } from '../../services/character-service.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  screenWidth: number;
  Header="HeaderNarrow";
  constructor() { this.getScreenSize}
  CharClass = "Barbarian";
  Level = 3;
  Player = "Critesk";
  Background = "Select Background";
  Race = "";
  Alignment = "";
  Test = "This is a Test";
  Languages = "This is a demonstration of how the language box expands when sufficient lines are contained to require expantion. The base size will be three lines, but will expand to as much as needed. This principle will be applied to every text diplay area.";
  

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
        } else if (this.screenWidth<=800){
          this.Header="HeaderNarrow";
        } else {
          this.Header="HeaderMiddle";
        }
  }
}
