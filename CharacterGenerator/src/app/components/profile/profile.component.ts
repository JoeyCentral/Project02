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
  

  races=[{name:"Elf"}, {name:"Dwarf"}, {name:"Human"}];
  aligns=[{name:"Lawful Good"}, {name:"Lawful Neutral"}, {name:"Lawful Evil"}];
  backgrounds=[{name:"Acolyte"}, {name:"Criminal"}, {name:"Entertainer"}];
  Str=10;Dex=10;Con=10;Int=10;Wis=10;Chr=10;
  StrMod=Math.round((this.Str-10)/2);
  DexMod=Math.round((this.Dex-10)/2);
  ConMod=Math.round((this.Con-10)/2);
  IntMod=Math.round((this.Int-10)/2);
  WisMod=Math.round((this.Wis-10)/2);
  ChrMod=Math.round((this.Chr-10)/2);


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
