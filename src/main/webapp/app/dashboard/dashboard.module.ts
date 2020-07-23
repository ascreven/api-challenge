import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { OpportunitiesSharedModule } from 'app/shared/shared.module';
import { DASHBOARD_ROUTE } from './dashboard.route';
import { DashboardComponent } from './dashboard.component';

@NgModule({
  imports: [OpportunitiesSharedModule, RouterModule.forChild([DASHBOARD_ROUTE])],
  declarations: [DashboardComponent],
})
export class DashboardModule {}
