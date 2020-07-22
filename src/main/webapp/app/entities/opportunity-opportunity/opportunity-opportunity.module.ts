import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OpportunitiesSharedModule } from 'app/shared/shared.module';
import { OpportunityOpportunityComponent } from './opportunity-opportunity.component';
import { OpportunityOpportunityDetailComponent } from './opportunity-opportunity-detail.component';
import { OpportunityOpportunityUpdateComponent } from './opportunity-opportunity-update.component';
import { OpportunityOpportunityDeleteDialogComponent } from './opportunity-opportunity-delete-dialog.component';
import { opportunityOpportunityRoute } from './opportunity-opportunity.route';

@NgModule({
  imports: [OpportunitiesSharedModule, RouterModule.forChild(opportunityOpportunityRoute)],
  declarations: [
    OpportunityOpportunityComponent,
    OpportunityOpportunityDetailComponent,
    OpportunityOpportunityUpdateComponent,
    OpportunityOpportunityDeleteDialogComponent,
  ],
  entryComponents: [OpportunityOpportunityDeleteDialogComponent],
})
export class OpportunitiesOpportunityOpportunityModule {}
