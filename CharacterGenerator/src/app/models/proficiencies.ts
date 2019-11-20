import { Backgrounds } from './backgrounds';
import { CharClass } from './charclass';

export class Proficiencies{
	id:number;
	prof_name:string;
	ability:number;
	description:string;
	background:[Backgrounds];
	charClass:[CharClass];
}