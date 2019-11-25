import { Pipe, PipeTransform } from '@angular/core';

import { Multiclass } from '../models/multiclass';

@Pipe({ name: 'round' })
export class RoundPipe implements PipeTransform {
  transform(value: number): number {
    return Math.floor(value);
  }
}

@Pipe({ name: 'class' })
export class ClassPipe implements PipeTransform {
  transform(value: Multiclass[]): string {
    if (value.length > 1) { return "Multiclass"; }
    else {
      const classitem = value[0];
      return classitem.charClass.classname;
    }
  }
}
@Pipe({ name: 'level' })
export class LevelPipe implements PipeTransform {
  transform(value: Multiclass[]): number {
    var totalLevel = 0;
    for (let multiclass of value) {
      totalLevel += multiclass.level;
    }
    return totalLevel;
  }
}

/** Need to figure out a way to retreieve the index, else move to unordox method*/

/** Sample parse : <h1>{{1234567890123456| stringparsertest : 6}}</h1> */

@Pipe({ name: 'stringparser' })
export class StringParserPipe implements PipeTransform {
  transform(value: String, index: number): any[] {
    var valueToBeSplit = value.toString();
    var result = splitNChars(valueToBeSplit, 2);
    return result[index];
  }
}

/** Parse and return array with index */
function splitNChars(txt, num) {
  var result = [];
  for (var i = 0; i < txt.length; i += num) {
    result.push(txt.substr(i, num));
  }
  return result;
}
