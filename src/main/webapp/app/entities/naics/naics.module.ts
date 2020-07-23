import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OpportunitiesSharedModule } from 'app/shared/shared.module';
import { NaicsComponent } from './naics.component';
import { NaicsDetailComponent } from './naics-detail.component';
import { naicsRoute } from './naics.route';

@NgModule({
  imports: [OpportunitiesSharedModule, RouterModule.forChild(naicsRoute)],
  declarations: [NaicsComponent, NaicsDetailComponent],
})
export class OpportunitiesNaicsModule {}
