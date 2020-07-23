import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OpportunitiesSharedModule } from 'app/shared/shared.module';
import { DIRECTORY_ROUTE } from './directory.route';
import { DirectoryComponent } from './directory.component';

@NgModule({
  imports: [OpportunitiesSharedModule, RouterModule.forChild([DIRECTORY_ROUTE])],
  declarations: [DirectoryComponent],
})
export class DirectoryModule {}
