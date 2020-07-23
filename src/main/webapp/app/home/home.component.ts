import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';

import { LoginModalService } from 'app/core/login/login-modal.service';
import { AccountService } from 'app/core/auth/account.service';
import { Account } from 'app/core/user/account.model';
import { ContractOpportunityService } from 'app/entities/contract-opportunity/contract-opportunity.service';

@Component({
  selector: 'jhi-home',
  templateUrl: './home.component.html',
  styleUrls: ['home.scss'],
})
export class HomeComponent implements OnInit, OnDestroy {
  account: Account | null = null;
  authSubscription?: Subscription;
  industryCounts: any;

  constructor(private accountService: AccountService,
    private contractOpportunityService: ContractOpportunityService,
    private loginModalService: LoginModalService) {}

  ngOnInit(): void {
    this.authSubscription = this.accountService.getAuthenticationState().subscribe(account => (this.account = account));
    const industryOppParams = {
      'parentCode.equal': '2362',
      'keywords.in': ["video", "training"],
      'setAside.equal': "sba"
    }
    this.contractOpportunityService.countIndustryOpps(industryOppParams).subscribe(res => this.industryCounts = res);
  }

  isAuthenticated(): boolean {
    return this.accountService.isAuthenticated();
  }

  login(): void {
    this.loginModalService.open();
  }

  ngOnDestroy(): void {
    if (this.authSubscription) {
      this.authSubscription.unsubscribe();
    }
  }
}
