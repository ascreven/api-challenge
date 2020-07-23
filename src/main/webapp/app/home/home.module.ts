import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OpportunitiesSharedModule } from 'app/shared/shared.module';
import { HOME_ROUTE } from './home.route';
import { HomeComponent } from './home.component';

import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { BarchartComponent } from './shared/barchart/barchart.component';

@NgModule({
  imports: [OpportunitiesSharedModule, BrowserModule, FormsModule, RouterModule.forChild([HOME_ROUTE])],
  declarations: [HomeComponent, BarchartComponent],
  providers: [],
  bootstrap: [AppComponent],
})
export class OpportunitiesHomeModule {}
