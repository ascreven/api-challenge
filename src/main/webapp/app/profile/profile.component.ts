import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { FormGroup, FormControl } from '@angular/forms';

import { LoginModalService } from 'app/core/login/login-modal.service';
import { ContractOpportunityService } from 'app/entities/contract-opportunity/contract-opportunity.service';
import { AccountService } from 'app/core/auth/account.service';
import { Account } from 'app/core/user/account.model';
import { IIndustryOpportunityCount } from 'app/shared/model/industry-opportunity-count.model';

@Component({
  selector: 'jhi-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss'],
})
export class ProfileComponent implements OnInit {
  account: Account | null = null;
  authSubscription?: Subscription;
  naicsCounts: IIndustryOpportunityCount[] = [];

  profileForm = new FormGroup({});

  public model: any[] = [
    {
      key: 'entity',
      label: 'You have 4 registered entities with 12 NAICS codes',
      show: true,
      naics: ['541310', '541330', '541340', '541370', '236220', '236210', '236116', '236118', '238350', '238390', '238910', '238990'],
    },
    {
      key: 'following',
      label: 'You are following 23 contract opportunities with 9 NAICS codes',
      show: true,
      naics: ['221115', '221118', '541310', '541330', '541340', '541370', '237990', '236210'],
    },
    {
      key: 'awards',
      label: 'Your entities have received 12 contract awards with 4 NAICS codes',
      show: true,
      naics: ['541310', '541330', '236220', '236210'],
    },
  ];

  public showNaics: string[] = [];

  constructor(
    private accountService: AccountService,
    private contractOpportunityService: ContractOpportunityService,
    private loginModalService: LoginModalService
  ) {
    this.setUpNAICS();
  }

  setUpNAICS(): void {
    const newValues: string[] = [];
    this.model.forEach(entry => {
      if (entry.show) {
        entry.naics.forEach((naics: string) => {
          if (!newValues.includes(naics)) {
            newValues.push(naics);
          }
        });
      }
    });
    this.showNaics = newValues;
  }

  ngOnInit(): void {
    this.authSubscription = this.accountService.getAuthenticationState().subscribe(account => (this.account = account));
    this.getNaicsCounts(this.getNaicsParams());
  }

  getNaicsCounts(naicsParams: any): void {
    this.contractOpportunityService.countIndustryOppsFromNaics(naicsParams).subscribe((res: IIndustryOpportunityCount[]) => {
      this.naicsCounts = res;
    });
  }

  isAuthenticated(): boolean {
    return this.accountService.isAuthenticated();
  }

  login(): void {
    this.loginModalService.open();
  }

  onProfileItemChange(event: any): void {
    if (event.target && event.target.name) {
      for (let i = 0; i < this.model.length; i++) {
        if (this.model[i].key === event.target.name) {
          this.model[i].show = !this.model[i].show;
        }
      }
    }
    this.setUpNAICS();
    this.getNaicsCounts(this.getNaicsParams());
  }

  getNaicsParams(): any {
    const naicsParams = {};
    if (this.showNaics.length) {
      naicsParams['code.in'] = this.showNaics;
    }
    return naicsParams;
  }

  ngOnDestroy(): void {
    if (this.authSubscription) {
      this.authSubscription.unsubscribe();
    }
  }
}
