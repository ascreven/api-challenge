export interface INaics {
  id?: number;
  code?: string;
  title?: string;
  description?: any;
}

export class Naics implements INaics {
  constructor(public id?: number, public code?: string, public title?: string, public description?: any) {}
}
