import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CharacterServiceService {
  Charname:string;
  Level:number;
  CharClass:string;
  Player:string;
  Languages:string;
  constructor() { }
}
