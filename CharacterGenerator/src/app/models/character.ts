import { User } from './user';
import { Profile } from './profile';
import { Info } from './info';
import { SpellList } from './spelllist';

export class Character{
    id:number;
    character_name:string;
    player:User;//Users type in backend
    playerName:string
    profile:Profile//Profile type in backend
    info:Info//Info type in backend
    spellList:SpellList//SpellList type in backend
}