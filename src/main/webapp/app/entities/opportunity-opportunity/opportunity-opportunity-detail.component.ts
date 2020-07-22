import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JhiDataUtils } from 'ng-jhipster';

import { IOpportunityOpportunity } from 'app/shared/model/opportunity-opportunity.model';

@Component({
  selector: 'jhi-opportunity-opportunity-detail',
  templateUrl: './opportunity-opportunity-detail.component.html',
})
export class OpportunityOpportunityDetailComponent implements OnInit {
  opportunityOpportunity: IOpportunityOpportunity | null = null;

  constructor(protected dataUtils: JhiDataUtils, protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ opportunityOpportunity }) => (this.opportunityOpportunity = opportunityOpportunity));
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
