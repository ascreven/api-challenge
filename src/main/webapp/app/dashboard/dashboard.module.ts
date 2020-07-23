import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { OpportunitiesSharedModule } from 'app/shared/shared.module';
import { DASHBOARD_ROUTE } from './dashboard.route';
import { DashboardComponent } from './dashboard.component';
import { FormatTitlePipe } from './format-title.pipe';

@NgModule({
  imports: [
    OpportunitiesSharedModule,
    RouterModule.forChild([DASHBOARD_ROUTE])
  ],
  declarations: [DashboardComponent, FormatTitlePipe],
})
export class DashboardModule {}
