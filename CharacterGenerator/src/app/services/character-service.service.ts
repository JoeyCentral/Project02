import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Character } from '../models/character';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CharacterServiceService {

  character: Character;


  constructor(private httpClient: HttpClient) { }

  charService(): Observable<Character[]>{
    const url = "http://localhost:8081/view/userid";
    
    return await this.httpClient.get<Character[]>(url, id);
  }
     
}
