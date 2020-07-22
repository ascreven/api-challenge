import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiDataUtils } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IContractOpportunity } from 'app/shared/model/contract-opportunity.model';
import { ContractOpportunityService } from './contract-opportunity.service';
import { ContractOpportunityDeleteDialogComponent } from './contract-opportunity-delete-dialog.component';

@Component({
  selector: 'jhi-contract-opportunity',
  templateUrl: './contract-opportunity.component.html',
})
export class ContractOpportunityComponent implements OnInit, OnDestroy {
  contractOpportunities?: IContractOpportunity[];
  eventSubscriber?: Subscription;

  constructor(
    protected contractOpportunityService: ContractOpportunityService,
    protected dataUtils: JhiDataUtils,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.contractOpportunityService
      .query()
      .subscribe((res: HttpResponse<IContractOpportunity[]>) => (this.contractOpportunities = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInContractOpportunities();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IContractOpportunity): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  byteSize(base64String: string): string {
    return this.dataUtils.byteSize(base64String);
  }

  openFile(contentType = '', base64String: string): void {
    return this.dataUtils.openFile(contentType, base64String);
  }

  registerChangeInContractOpportunities(): void {
    this.eventSubscriber = this.eventManager.subscribe('contractOpportunityListModification', () => this.loadAll());
  }

  delete(contractOpportunity: IContractOpportunity): void {
    const modalRef = this.modalService.open(ContractOpportunityDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.contractOpportunity = contractOpportunity;
  }
}
