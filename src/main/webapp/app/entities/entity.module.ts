import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'opportunity',
        loadChildren: () => import('./opportunity/opportunity.module').then(m => m.OpportunitiesOpportunityModule),
      },
      {
        path: 'opportunity-opportunity',
        loadChildren: () =>
          import('./opportunity-opportunity/opportunity-opportunity.module').then(m => m.OpportunitiesOpportunityOpportunityModule),
      },
      {
        path: 'contract-opportunity',
        loadChildren: () =>
          import('./contract-opportunity/contract-opportunity.module').then(m => m.OpportunitiesContractOpportunityModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class OpportunitiesEntityModule {}
