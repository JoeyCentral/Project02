import { Component, OnInit } from '@angular/core';
import { HostListener } from "@angular/core";

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
  constructor() {this.getScreenSize}
  Age:10;
  Charname = "Freddy";
  Skin:"Green";
  Hair:"Yellow";
  Eyes: "Blue";
  Height: 72;
  Weight: 200;

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
