import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { OpportunitiesSharedModule } from 'app/shared/shared.module';
import { OpportunitiesCoreModule } from 'app/core/core.module';
import { OpportunitiesAppRoutingModule } from './app-routing.module';
import { OpportunitiesHomeModule } from './home/home.module';
import { OpportunitiesEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';
import { BarchartComponent } from './barchart/barchart.component';

@NgModule({
  imports: [
    BrowserModule,
    OpportunitiesSharedModule,
    OpportunitiesCoreModule,
    OpportunitiesHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    OpportunitiesEntityModule,
    OpportunitiesAppRoutingModule,
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent, BarchartComponent],
  bootstrap: [MainComponent],
})
export class OpportunitiesAppModule {}
