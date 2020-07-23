import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'jhi-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss'],
})
export class ProfileComponent implements OnInit {
  public model: any[] = [
    {
      key: 'entity',
      label: 'You have 4 registered entities with 12 NAICS codes',
      show: true,
      naics: ['541310', '541330', '541340', '541370', '236220', '236210', '236116', '236118', '238350', '238390', '238910', '238990'],
    },
    {
      key: 'entity',
      label: 'You are following 23 contract opportunities with 6 NAICS codes',
      show: true,
      naics: ['541310', '541330', '541340', '541370', '236220', '236210'],
    },
    {
      key: 'entity',
      label: 'Your entities have received 12 contract awards with 4 NAICS codes',
      show: true,
      naics: ['541310', '541330', '236220', '236210'],
    },
  ];

  public showNaics: string[] = [];

  constructor() {
    this.setUpNAICS();
  }

  setUpNAICS(): void {
    const newValues: string[] = [];
    this.model.forEach(entry => {
      entry.naics.forEach((naics: string) => {
        if (!newValues.includes(naics)) {
          newValues.push(naics);
        }
      });
    });
    this.showNaics = newValues;
  }

  ngOnInit(): void {}
}
