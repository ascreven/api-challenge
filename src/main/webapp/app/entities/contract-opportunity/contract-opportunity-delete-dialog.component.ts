import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IContractOpportunity } from 'app/shared/model/contract-opportunity.model';
import { ContractOpportunityService } from './contract-opportunity.service';

@Component({
  templateUrl: './contract-opportunity-delete-dialog.component.html',
})
export class ContractOpportunityDeleteDialogComponent {
  contractOpportunity?: IContractOpportunity;

  constructor(
    protected contractOpportunityService: ContractOpportunityService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.contractOpportunityService.delete(id).subscribe(() => {
      this.eventManager.broadcast('contractOpportunityListModification');
      this.activeModal.close();
    });
  }
}
