import { Spells } from './spells';
import { Features } from './features';

export class SpellList{
	id:number;
	castingFocus:string;
	spellsLeft:number;
	component:string;
	spellsKnown:[Spells];
	spellsAvilable:[Spells];
	features:[Features];
	
}