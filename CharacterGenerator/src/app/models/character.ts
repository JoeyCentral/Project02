import { User } from './user';
import { Profile } from './profile';
import { Info } from './info';
import { SpellList } from './spelllist';
import { Multiclass } from './multiclass';

export class Character{
    id:number;
    character_name:string;
    player:User;
    playerName:string
    profile:Profile
    info:Info
    spellList:SpellList
    multiclass:Multiclass[]
}