import { browser, ExpectedConditions as ec, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

import {
  OpportunityOpportunityComponentsPage,
  OpportunityOpportunityDeleteDialog,
  OpportunityOpportunityUpdatePage,
} from './opportunity-opportunity.page-object';

const expect = chai.expect;

describe('OpportunityOpportunity e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let opportunityOpportunityComponentsPage: OpportunityOpportunityComponentsPage;
  let opportunityOpportunityUpdatePage: OpportunityOpportunityUpdatePage;
  let opportunityOpportunityDeleteDialog: OpportunityOpportunityDeleteDialog;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load OpportunityOpportunities', async () => {
    await navBarPage.goToEntity('opportunity-opportunity');
    opportunityOpportunityComponentsPage = new OpportunityOpportunityComponentsPage();
    await browser.wait(ec.visibilityOf(opportunityOpportunityComponentsPage.title), 5000);
    expect(await opportunityOpportunityComponentsPage.getTitle()).to.eq('Opportunity Opportunities');
    await browser.wait(
      ec.or(ec.visibilityOf(opportunityOpportunityComponentsPage.entities), ec.visibilityOf(opportunityOpportunityComponentsPage.noResult)),
      1000
    );
  });

  it('should load create OpportunityOpportunity page', async () => {
    await opportunityOpportunityComponentsPage.clickOnCreateButton();
    opportunityOpportunityUpdatePage = new OpportunityOpportunityUpdatePage();
    expect(await opportunityOpportunityUpdatePage.getPageTitle()).to.eq('Create or edit a Opportunity Opportunity');
    await opportunityOpportunityUpdatePage.cancel();
  });

  it('should create and save OpportunityOpportunities', async () => {
    const nbButtonsBeforeCreate = await opportunityOpportunityComponentsPage.countDeleteButtons();

    await opportunityOpportunityComponentsPage.clickOnCreateButton();

    await promise.all([
      opportunityOpportunityUpdatePage.setContractIdInput('contractId'),
      opportunityOpportunityUpdatePage.setTitleInput('title'),
      opportunityOpportunityUpdatePage.setSolInput('sol'),
      opportunityOpportunityUpdatePage.setAgencyInput('agency'),
      opportunityOpportunityUpdatePage.setSubTierInput('subTier'),
      opportunityOpportunityUpdatePage.setOfficeInput('office'),
      opportunityOpportunityUpdatePage.setPosteddateInput('2000-12-31'),
      opportunityOpportunityUpdatePage.setTypeInput('type'),
      opportunityOpportunityUpdatePage.setBasetypeInput('basetype'),
      opportunityOpportunityUpdatePage.setSetasidecodeInput('setasidecode'),
      opportunityOpportunityUpdatePage.setSetasideInput('setaside'),
      opportunityOpportunityUpdatePage.setResponsedeadlineInput('2000-12-31'),
      opportunityOpportunityUpdatePage.setNaicscodeInput('naicscode'),
      opportunityOpportunityUpdatePage.setClassificationcodeInput('classificationcode'),
      opportunityOpportunityUpdatePage.setPopstateInput('popstate'),
      opportunityOpportunityUpdatePage.setPopzipInput('popzip'),
      opportunityOpportunityUpdatePage.setPopcountryInput('popcountry'),
      opportunityOpportunityUpdatePage.setActiveInput('active'),
      opportunityOpportunityUpdatePage.setOrganizationtypeInput('organizationtype'),
      opportunityOpportunityUpdatePage.setDescriptionInput('description'),
    ]);

    expect(await opportunityOpportunityUpdatePage.getContractIdInput()).to.eq(
      'contractId',
      'Expected ContractId value to be equals to contractId'
    );
    expect(await opportunityOpportunityUpdatePage.getTitleInput()).to.eq('title', 'Expected Title value to be equals to title');
    expect(await opportunityOpportunityUpdatePage.getSolInput()).to.eq('sol', 'Expected Sol value to be equals to sol');
    expect(await opportunityOpportunityUpdatePage.getAgencyInput()).to.eq('agency', 'Expected Agency value to be equals to agency');
    expect(await opportunityOpportunityUpdatePage.getSubTierInput()).to.eq('subTier', 'Expected SubTier value to be equals to subTier');
    expect(await opportunityOpportunityUpdatePage.getOfficeInput()).to.eq('office', 'Expected Office value to be equals to office');
    expect(await opportunityOpportunityUpdatePage.getPosteddateInput()).to.eq(
      '2000-12-31',
      'Expected posteddate value to be equals to 2000-12-31'
    );
    expect(await opportunityOpportunityUpdatePage.getTypeInput()).to.eq('type', 'Expected Type value to be equals to type');
    expect(await opportunityOpportunityUpdatePage.getBasetypeInput()).to.eq('basetype', 'Expected Basetype value to be equals to basetype');
    expect(await opportunityOpportunityUpdatePage.getSetasidecodeInput()).to.eq(
      'setasidecode',
      'Expected Setasidecode value to be equals to setasidecode'
    );
    expect(await opportunityOpportunityUpdatePage.getSetasideInput()).to.eq('setaside', 'Expected Setaside value to be equals to setaside');
    expect(await opportunityOpportunityUpdatePage.getResponsedeadlineInput()).to.eq(
      '2000-12-31',
      'Expected responsedeadline value to be equals to 2000-12-31'
    );
    expect(await opportunityOpportunityUpdatePage.getNaicscodeInput()).to.eq(
      'naicscode',
      'Expected Naicscode value to be equals to naicscode'
    );
    expect(await opportunityOpportunityUpdatePage.getClassificationcodeInput()).to.eq(
      'classificationcode',
      'Expected Classificationcode value to be equals to classificationcode'
    );
    expect(await opportunityOpportunityUpdatePage.getPopstateInput()).to.eq('popstate', 'Expected Popstate value to be equals to popstate');
    expect(await opportunityOpportunityUpdatePage.getPopzipInput()).to.eq('popzip', 'Expected Popzip value to be equals to popzip');
    expect(await opportunityOpportunityUpdatePage.getPopcountryInput()).to.eq(
      'popcountry',
      'Expected Popcountry value to be equals to popcountry'
    );
    expect(await opportunityOpportunityUpdatePage.getActiveInput()).to.eq('active', 'Expected Active value to be equals to active');
    expect(await opportunityOpportunityUpdatePage.getOrganizationtypeInput()).to.eq(
      'organizationtype',
      'Expected Organizationtype value to be equals to organizationtype'
    );
    expect(await opportunityOpportunityUpdatePage.getDescriptionInput()).to.eq(
      'description',
      'Expected Description value to be equals to description'
    );

    await opportunityOpportunityUpdatePage.save();
    expect(await opportunityOpportunityUpdatePage.getSaveButton().isPresent(), 'Expected save button disappear').to.be.false;

    expect(await opportunityOpportunityComponentsPage.countDeleteButtons()).to.eq(
      nbButtonsBeforeCreate + 1,
      'Expected one more entry in the table'
    );
  });

  it('should delete last OpportunityOpportunity', async () => {
    const nbButtonsBeforeDelete = await opportunityOpportunityComponentsPage.countDeleteButtons();
    await opportunityOpportunityComponentsPage.clickOnLastDeleteButton();

    opportunityOpportunityDeleteDialog = new OpportunityOpportunityDeleteDialog();
    expect(await opportunityOpportunityDeleteDialog.getDialogTitle()).to.eq(
      'Are you sure you want to delete this Opportunity Opportunity?'
    );
    await opportunityOpportunityDeleteDialog.clickOnConfirmButton();

    expect(await opportunityOpportunityComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
