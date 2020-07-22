import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiDataUtils } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IOpportunityOpportunity } from 'app/shared/model/opportunity-opportunity.model';
import { OpportunityOpportunityService } from './opportunity-opportunity.service';
import { OpportunityOpportunityDeleteDialogComponent } from './opportunity-opportunity-delete-dialog.component';

@Component({
  selector: 'jhi-opportunity-opportunity',
  templateUrl: './opportunity-opportunity.component.html',
})
export class OpportunityOpportunityComponent implements OnInit, OnDestroy {
  opportunityOpportunities?: IOpportunityOpportunity[];
  eventSubscriber?: Subscription;

  constructor(
    protected opportunityOpportunityService: OpportunityOpportunityService,
    protected dataUtils: JhiDataUtils,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.opportunityOpportunityService
      .query()
      .subscribe((res: HttpResponse<IOpportunityOpportunity[]>) => (this.opportunityOpportunities = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInOpportunityOpportunities();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IOpportunityOpportunity): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  byteSize(base64String: string): string {
    return this.dataUtils.byteSize(base64String);
  }

  openFile(contentType = '', base64String: string): void {
    return this.dataUtils.openFile(contentType, base64String);
  }

  registerChangeInOpportunityOpportunities(): void {
    this.eventSubscriber = this.eventManager.subscribe('opportunityOpportunityListModification', () => this.loadAll());
  }

  delete(opportunityOpportunity: IOpportunityOpportunity): void {
    const modalRef = this.modalService.open(OpportunityOpportunityDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.opportunityOpportunity = opportunityOpportunity;
  }
}
