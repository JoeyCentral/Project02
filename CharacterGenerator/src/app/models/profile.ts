import { Backgrounds } from './backgrounds';
import { Proficiencies } from './proficiencies';
import { Features } from './features';
import { Race } from './race';
import { CustomRoll } from './customroll';

export class Profile{
	id:number;
	abilityScores:string;
	inspiration:number;
	alignmnet:string;
	experience:number;
	maximumHealth:number;
	ac:number;
	deathSaves:number;
	hitDice:number;
	currentHealth:number;
	inventory:string;
	languages:string;
	race:Race;
	background:Backgrounds;
	proficiencies:Proficiencies[];
	features:Features[];
	roll:CustomRoll[];
	tempHP:Number;
}