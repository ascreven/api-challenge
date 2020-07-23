import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { FormBuilder, FormArray } from '@angular/forms';

import { LoginModalService } from 'app/core/login/login-modal.service';
import { ContractOpportunityService } from 'app/entities/contract-opportunity/contract-opportunity.service';
import { AccountService } from 'app/core/auth/account.service';
import { Account } from 'app/core/user/account.model';
import { IIndustryOpportunityCount } from 'app/shared/model/industry-opportunity-count.model';

@Component({
  selector: 'jhi-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['dashboard.scss'],
})
export class DashboardComponent implements OnInit, OnDestroy {
  account: Account | null = null;
  authSubscription?: Subscription;
  industryCounts: IIndustryOpportunityCount[] = [];
  industryCountSubscription?: Subscription;

  dashboardForm = this.fb.group({
    parentcode: [],
    keywords: this.fb.array([
      this.fb.control('')
    ]),
    setaside: []
  });

  get keywords(): any {
    return this.dashboardForm.get('keywords') as FormArray;
  }

  constructor(
    private accountService: AccountService,
    private contractOpportunityService: ContractOpportunityService,
    private fb: FormBuilder,
    private loginModalService: LoginModalService
  ) {}

  ngOnInit(): void {
    this.authSubscription = this.accountService.getAuthenticationState().subscribe(account => (this.account = account));
    this.getIndustryOpportunityCount();
  }

  getIndustryOpportunityCount(industryOppParams = {}): void {
    this.industryCountSubscription = this.contractOpportunityService
      .countIndustryOpps(industryOppParams)
      .subscribe((res: IIndustryOpportunityCount[]) => (this.industryCounts = res));
  }

  isAuthenticated(): boolean {
    return this.accountService.isAuthenticated();
  }

  login(): void {
    this.loginModalService.open();
  }

  addKeyword(): void {
    this.keywords.push(this.fb.control(''));
  }

  onSubmit(): void {
    const industryOppParams = {
      'keywords.in': this.keywords.value,
      'setaside.equal': this.dashboardForm.value.setaside,
      'parentcode.equal': this.dashboardForm.value.parentcode
    };
    this.getIndustryOpportunityCount(industryOppParams);
  }

  ngOnDestroy(): void {
    if (this.authSubscription) {
      this.authSubscription.unsubscribe();
    }
  }
}
