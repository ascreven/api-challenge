import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'formatTitle'
})
export class FormatTitlePipe implements PipeTransform {

  transform(val: string): unknown {
    const lastChar = val.charAt(val.length - 1);
    if (lastChar === "T") {
      return val.slice(0, -1)
    } else {
      return val;
    }
  }
}
