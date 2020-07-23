import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OpportunitiesSharedModule } from 'app/shared/shared.module';

import { ProfileRoutingModule } from './profile-routing.module';
import { ProfileComponent } from './profile.component';

@NgModule({
  declarations: [ProfileComponent],
  imports: [CommonModule, OpportunitiesSharedModule, ProfileRoutingModule],
})
export class ProfileModule {}
