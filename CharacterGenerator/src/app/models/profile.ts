import { Backgrounds } from './backgrounds';
import { Proficiencies } from './proficiencies';
import { Features } from './features';
import { Race } from './race';
import { CustomRoll } from './customroll';

export class Profile{
	id:number;
	abilityScores:string;
	inspiration:number;
	alignment:string;
	experience:number;
	maximumHealth:number;
	ac:number;
	deathSaves:number;
	hitDice:string;
	currentHealth:number;
	inventory:string;
	languages:string;
	race:Race;
	background:Backgrounds;
	proficiencies:Proficiencies[];
	features:Features[];
	roll:CustomRoll[];
	tempHP:Number;
	speed:Number;
	vision:number;
}