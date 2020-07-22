import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IOpportunityOpportunity } from 'app/shared/model/opportunity-opportunity.model';
import { OpportunityOpportunityService } from './opportunity-opportunity.service';

@Component({
  templateUrl: './opportunity-opportunity-delete-dialog.component.html',
})
export class OpportunityOpportunityDeleteDialogComponent {
  opportunityOpportunity?: IOpportunityOpportunity;

  constructor(
    protected opportunityOpportunityService: OpportunityOpportunityService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.opportunityOpportunityService.delete(id).subscribe(() => {
      this.eventManager.broadcast('opportunityOpportunityListModification');
      this.activeModal.close();
    });
  }
}
