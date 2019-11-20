import { Component, OnInit } from '@angular/core';
import { HostListener } from "@angular/core";

@Component({
  selector: 'app-character',
  templateUrl: './character.component.html',
  styleUrls: ['./character.component.css']
})
export class CharacterComponent implements OnInit {
  screenWidth: number;
  Header="Narrow";
  constructor() { this.getScreenSize(); }

  ngOnInit() {
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
