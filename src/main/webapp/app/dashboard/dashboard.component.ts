import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { FormGroup, FormControl } from '@angular/forms';

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
  industryCounts: any[] = [];
  message: String = 'Please wait while we gather frequently used NCAIS codes.';
  keywords: String[] = [];

  dashboardForm = new FormGroup({
    parentCode: new FormControl(''),
    keyword: new FormControl(''),
    setAside: new FormControl(''),
  });

  constructor(
    private accountService: AccountService,
    private contractOpportunityService: ContractOpportunityService,
    private loginModalService: LoginModalService
  ) {}

  ngOnInit(): void {
    this.authSubscription = this.accountService.getAuthenticationState().subscribe(account => (this.account = account));
    this.getIndustryOpportunityCount();
  }

  getIndustryOpportunityCount(industryOppParams = {}): void {
    this.message = 'Please wait while we gather frequently used NCAIS codes.';
    this.industryCounts = [];
    this.contractOpportunityService.countIndustryOpps(industryOppParams).subscribe((res: IIndustryOpportunityCount[]) => {
      this.industryCounts = res;
      this.message = res.length === 0 ? 'No NCAIS codes matched your filters.' : '';
    });
  }

  isAuthenticated(): boolean {
    return this.accountService.isAuthenticated();
  }

  viewDetails(code: any): void {
    this.dashboardForm.controls.parentCode.setValue(code);
    this.searchOpportunities();
  }

  login(): void {
    this.loginModalService.open();
  }

  addKeyword(): void {
    this.keywords.push(this.dashboardForm.value.keyword);
    this.dashboardForm.controls.keyword.reset();
  }

  resetForm(): void {
    this.keywords = [];
    this.dashboardForm.reset();
  }

  removeKeyword(index: number): void {
    this.keywords.splice(index);
  }

  searchOpportunities(): void {
    const filters = this.dashboardForm.value;

    const industryOppParams = {};
    if (this.keywords.length) {
      industryOppParams['keywords.in'] = this.keywords;
    }
    if (filters.setAside) {
      industryOppParams['setAside.equals'] = filters.setAside;
    }
    if (filters.parentCode) {
      industryOppParams['parentCode.equals'] = filters.parentCode;
    }
    this.getIndustryOpportunityCount(industryOppParams);
  }

  ngOnDestroy(): void {
    if (this.authSubscription) {
      this.authSubscription.unsubscribe();
    }
  }
}
