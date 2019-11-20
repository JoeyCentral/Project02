import { Profile } from './profile';

export class CustomRoll {
    id:number;
    roll_name:string;
    ability:number;
    modifier:number;
    damage_amount:number;
    damage_type:string;
    char_id:Profile;//Profile type in backend
}