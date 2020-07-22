import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OpportunitiesSharedModule } from 'app/shared/shared.module';
import { ContractOpportunityComponent } from './contract-opportunity.component';
import { ContractOpportunityDetailComponent } from './contract-opportunity-detail.component';
import { ContractOpportunityUpdateComponent } from './contract-opportunity-update.component';
import { ContractOpportunityDeleteDialogComponent } from './contract-opportunity-delete-dialog.component';
import { contractOpportunityRoute } from './contract-opportunity.route';

@NgModule({
  imports: [OpportunitiesSharedModule, RouterModule.forChild(contractOpportunityRoute)],
  declarations: [
    ContractOpportunityComponent,
    ContractOpportunityDetailComponent,
    ContractOpportunityUpdateComponent,
    ContractOpportunityDeleteDialogComponent,
  ],
  entryComponents: [ContractOpportunityDeleteDialogComponent],
})
export class OpportunitiesContractOpportunityModule {}
