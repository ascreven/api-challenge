import { browser, ExpectedConditions as ec } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

import { NaicsComponentsPage } from './naics.page-object';

const expect = chai.expect;

describe('Naics e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let naicsComponentsPage: NaicsComponentsPage;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load Naics', async () => {
    await navBarPage.goToEntity('naics');
    naicsComponentsPage = new NaicsComponentsPage();
    await browser.wait(ec.visibilityOf(naicsComponentsPage.title), 5000);
    expect(await naicsComponentsPage.getTitle()).to.eq('Naics');
    await browser.wait(ec.or(ec.visibilityOf(naicsComponentsPage.entities), ec.visibilityOf(naicsComponentsPage.noResult)), 1000);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
