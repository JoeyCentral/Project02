import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Character } from '../models/character';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CharacterService {

  characterList: Character[];
  character : Character;
  constructor(private httpClient: HttpClient) { }
  


  ngOnInit(){
  }
  async saveCharacterHttp(c:Character) {
    const url = "http://localhost:8081/character/save";
    const data = await this.httpClient.post(url, c).toPromise();
    return JSON.parse(JSON.stringify(data));
  };
  async copyCharacterHttp(c:Character) {
    const url = "http://localhost:8081/character/copy";
    const data = await this.httpClient.post(url, c).toPromise();
    return JSON.parse(JSON.stringify(data));
  };
  async shareCharacterHttp(c:Character) {
    const url = "http://localhost:8081/character/share";
    const data = await this.httpClient.post(url, c).toPromise();
    return JSON.parse(JSON.stringify(data));
  };
}