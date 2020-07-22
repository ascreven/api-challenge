import { browser, ExpectedConditions as ec } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

import { ContractOpportunityComponentsPage } from './contract-opportunity.page-object';

const expect = chai.expect;

describe('ContractOpportunity e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let contractOpportunityComponentsPage: ContractOpportunityComponentsPage;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load ContractOpportunities', async () => {
    await navBarPage.goToEntity('contract-opportunity');
    contractOpportunityComponentsPage = new ContractOpportunityComponentsPage();
    await browser.wait(ec.visibilityOf(contractOpportunityComponentsPage.title), 5000);
    expect(await contractOpportunityComponentsPage.getTitle()).to.eq('Contract Opportunities');
    await browser.wait(
      ec.or(ec.visibilityOf(contractOpportunityComponentsPage.entities), ec.visibilityOf(contractOpportunityComponentsPage.noResult)),
      1000
    );
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
