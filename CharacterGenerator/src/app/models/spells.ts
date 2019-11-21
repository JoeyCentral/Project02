import { Race } from './race';
import { CharClass } from './charclass';
import { Features } from './features';

export class Spells{
    id:number;
    spellName:string;
    spellLevel:number;
    school:number;
    castTime:string;
    spellRange:number;
    components:string;
    duration:string;
    description:string;
    race:[Race];
    charClass:[CharClass];
    features:[Features];
    
}