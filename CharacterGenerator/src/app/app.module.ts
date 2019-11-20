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


@Pipe({name: 'round'})
export class RoundPipe implements PipeTransform {
    /**
     *
     * @param value
     * @returns {number}
     */
    transform(value: number): number {
        return Math.floor(value);
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
    RoundPipe
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
