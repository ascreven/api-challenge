import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OpportunitiesSharedModule } from 'app/shared/shared.module';
import { HOME_ROUTE } from './home.route';
import { HomeComponent } from './home.component';

@NgModule({
  imports: [OpportunitiesSharedModule, RouterModule.forChild([HOME_ROUTE])],
  declarations: [HomeComponent],
})
export class OpportunitiesHomeModule {}
