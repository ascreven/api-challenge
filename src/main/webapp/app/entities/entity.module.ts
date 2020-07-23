import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'contract-opportunity',
        loadChildren: () =>
          import('./contract-opportunity/contract-opportunity.module').then(m => m.OpportunitiesContractOpportunityModule),
      },
      {
        path: 'naics',
        loadChildren: () => import('./naics/naics.module').then(m => m.OpportunitiesNaicsModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class OpportunitiesEntityModule {}
