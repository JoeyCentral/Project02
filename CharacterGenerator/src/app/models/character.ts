import { SpellList } from './spelllist';
import { Info } from './info';
import { Profile } from 'selenium-webdriver/firefox';
import { User } from './user';

export class Character{
    id:number;
    character_name:string;
    player:User;
    playerName:string
    profile:Profile;
    info:Info;
    spellList:SpellList;

 
}
