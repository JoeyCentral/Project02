import { User } from './user';
import { Profile } from './profile';
import { Info } from './info';
import { SpellList } from './spelllist';

export class Character{
    id:number;
    character_name:string;
    player:User;
    playerName:string
    profile:Profile
    info:Info
    spellList:SpellList
}
