import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {Pipe, PipeTransform} from "@angular/core"
//import { Router } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CharacterComponent } from './components/character/character.component';
import { LoginComponent } from './components/login/login.component';
import { ProfileComponent } from './components/profile/profile.component';
import { InfoComponent } from './components/info/info.component';
import { SpellsComponent } from './components/spells/spells.component';
import { Multiclass } from './models/multiclass';

@Pipe({name: 'round'})
export class RoundPipe implements PipeTransform {
    transform(value: number): number {
        return Math.floor(value);
    }
}

@Pipe({name: 'class'})
export class ClassPipe implements PipeTransform {
    transform(value: Multiclass[]): string {
      if(value.length>1){return "Multiclass";}
      else {
        const classitem=value[0];
        return classitem.charClass.classname;
      }
  }
}
@Pipe({name: 'level'})
export class LevelPipe implements PipeTransform {
    transform(value: Multiclass[]): number {
      var totalLevel = 0;
      for(let multiclass of value){
        totalLevel+=multiclass.level;
      }
      return totalLevel;
      }
  }






@NgModule({
  declarations: [
    AppComponent,
    CharacterComponent,
    LoginComponent,
    ProfileComponent,
    InfoComponent,
    SpellsComponent,
    RoundPipe,
    ClassPipe,
    LevelPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    //Router
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }


