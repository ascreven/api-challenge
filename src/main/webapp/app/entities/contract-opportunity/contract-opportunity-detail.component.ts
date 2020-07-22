import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JhiDataUtils } from 'ng-jhipster';

import { IContractOpportunity } from 'app/shared/model/contract-opportunity.model';

@Component({
  selector: 'jhi-contract-opportunity-detail',
  templateUrl: './contract-opportunity-detail.component.html',
})
export class ContractOpportunityDetailComponent implements OnInit {
  contractOpportunity: IContractOpportunity | null = null;

  constructor(protected dataUtils: JhiDataUtils, protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ contractOpportunity }) => (this.contractOpportunity = contractOpportunity));
  }

  byteSize(base64String: string): string {
    return this.dataUtils.byteSize(base64String);
  }

  openFile(contentType = '', base64String: string): void {
    this.dataUtils.openFile(contentType, base64String);
  }

  previousState(): void {
    window.history.back();
  }
}
