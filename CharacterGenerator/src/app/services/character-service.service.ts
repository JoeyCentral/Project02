import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Character } from '../models/character';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CharacterService {

  characterList: Character[];
  character: Character;
  constructor(private httpClient: HttpClient) { }

  ngOnInit(){
    this.character = null;
  }

  async getCharacters(id: number){
    return this.httpClient.get<Character>("character/view"+id).toPromise();
  }

  async getMyCharacter(charId: number){
    return this.httpClient.get<Character[]>("character/select/"+charId).toPromise();
  }
/** 
  async saveCharacter(id: Character){
    return this.httpClient.post<Character>("character/save").toPromise();
  }
  async shareCharacter(id: Character){
    return this.httpClient.post<Character>("character/copy").toPromise();
  }
  async copyCharacter(id: number){
    return this.httpClient.post<Character>("character/share").toPromise();
  }
  async deleteCharacter(id: number){
    return this.httpClient.delete<Character>("character/delete"+id).toPromise();
  }
*/



}