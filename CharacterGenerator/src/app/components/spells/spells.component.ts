import { Component, OnInit } from '@angular/core';
import { HostListener } from "@angular/core";
import { CharacterService } from 'src/app/services/character-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-spells',
  templateUrl: './spells.component.html',
  styleUrls: ['./spells.component.css']
})
export class SpellsComponent implements OnInit {
  screenWidth: number;
  Header="HeaderNarrow";
  WidthControl="Narrow";
  MaxWidth="MNarrow";
  DoubleColumn = "col-md-12 m-0 p-0 mx-auto";
  SingleColumn = "col-md-12 m-0 p-0 mx-auto";
  constructor(private charServe: CharacterService, private router: Router) {this.getScreenSize }

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

  }

  async SaveAndExit(){

    this.router.navigateByUrl("/character");
  }
  async SaveToDatabase(){

    let x = await this.charServe.saveCharacterHttp(this.charServe.character);
  }
  Exit(){
    this.router.navigateByUrl("/character");
  }
  async Copy(){

    let x = await this.charServe.copyCharacterHttp(this.charServe.character);
  }
  async Share(){

    let Shared = this.charServe.character;
    let x = await this.charServe.shareCharacterHttp(Shared);
  }
  async Delete(){
    await this.charServe.deleteCharacterHttp(this.charServe.character.id);
  }
}
