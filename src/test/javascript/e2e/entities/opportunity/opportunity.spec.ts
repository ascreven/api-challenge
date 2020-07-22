import { browser, ExpectedConditions as ec, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

import { OpportunityComponentsPage, OpportunityDeleteDialog, OpportunityUpdatePage } from './opportunity.page-object';

const expect = chai.expect;

describe('Opportunity e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let opportunityComponentsPage: OpportunityComponentsPage;
  let opportunityUpdatePage: OpportunityUpdatePage;
  let opportunityDeleteDialog: OpportunityDeleteDialog;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load Opportunities', async () => {
    await navBarPage.goToEntity('opportunity');
    opportunityComponentsPage = new OpportunityComponentsPage();
    await browser.wait(ec.visibilityOf(opportunityComponentsPage.title), 5000);
    expect(await opportunityComponentsPage.getTitle()).to.eq('Opportunities');
    await browser.wait(
      ec.or(ec.visibilityOf(opportunityComponentsPage.entities), ec.visibilityOf(opportunityComponentsPage.noResult)),
      1000
    );
  });

  it('should load create Opportunity page', async () => {
    await opportunityComponentsPage.clickOnCreateButton();
    opportunityUpdatePage = new OpportunityUpdatePage();
    expect(await opportunityUpdatePage.getPageTitle()).to.eq('Create or edit a Opportunity');
    await opportunityUpdatePage.cancel();
  });

  it('should create and save Opportunities', async () => {
    const nbButtonsBeforeCreate = await opportunityComponentsPage.countDeleteButtons();

    await opportunityComponentsPage.clickOnCreateButton();

    await promise.all([
      opportunityUpdatePage.setContractIdInput('contractId'),
      opportunityUpdatePage.setTitleInput('title'),
      opportunityUpdatePage.setSolInput('sol'),
      opportunityUpdatePage.setAgencyInput('agency'),
      opportunityUpdatePage.setSubTierInput('subTier'),
      opportunityUpdatePage.setOfficeInput('office'),
      opportunityUpdatePage.setPosteddateInput('2000-12-31'),
      opportunityUpdatePage.setTypeInput('type'),
      opportunityUpdatePage.setBasetypeInput('basetype'),
      opportunityUpdatePage.setSetasidecodeInput('setasidecode'),
      opportunityUpdatePage.setSetasideInput('setaside'),
      opportunityUpdatePage.setResponsedeadlineInput('2000-12-31'),
      opportunityUpdatePage.setNaicscodeInput('naicscode'),
      opportunityUpdatePage.setClassificationcodeInput('classificationcode'),
      opportunityUpdatePage.setPopstateInput('popstate'),
      opportunityUpdatePage.setPopzipInput('popzip'),
      opportunityUpdatePage.setPopcountryInput('popcountry'),
      opportunityUpdatePage.setActiveInput('active'),
      opportunityUpdatePage.setOrganizationtypeInput('organizationtype'),
      opportunityUpdatePage.setDescriptionInput('description'),
    ]);

    expect(await opportunityUpdatePage.getContractIdInput()).to.eq('contractId', 'Expected ContractId value to be equals to contractId');
    expect(await opportunityUpdatePage.getTitleInput()).to.eq('title', 'Expected Title value to be equals to title');
    expect(await opportunityUpdatePage.getSolInput()).to.eq('sol', 'Expected Sol value to be equals to sol');
    expect(await opportunityUpdatePage.getAgencyInput()).to.eq('agency', 'Expected Agency value to be equals to agency');
    expect(await opportunityUpdatePage.getSubTierInput()).to.eq('subTier', 'Expected SubTier value to be equals to subTier');
    expect(await opportunityUpdatePage.getOfficeInput()).to.eq('office', 'Expected Office value to be equals to office');
    expect(await opportunityUpdatePage.getPosteddateInput()).to.eq('2000-12-31', 'Expected posteddate value to be equals to 2000-12-31');
    expect(await opportunityUpdatePage.getTypeInput()).to.eq('type', 'Expected Type value to be equals to type');
    expect(await opportunityUpdatePage.getBasetypeInput()).to.eq('basetype', 'Expected Basetype value to be equals to basetype');
    expect(await opportunityUpdatePage.getSetasidecodeInput()).to.eq(
      'setasidecode',
      'Expected Setasidecode value to be equals to setasidecode'
    );
    expect(await opportunityUpdatePage.getSetasideInput()).to.eq('setaside', 'Expected Setaside value to be equals to setaside');
    expect(await opportunityUpdatePage.getResponsedeadlineInput()).to.eq(
      '2000-12-31',
      'Expected responsedeadline value to be equals to 2000-12-31'
    );
    expect(await opportunityUpdatePage.getNaicscodeInput()).to.eq('naicscode', 'Expected Naicscode value to be equals to naicscode');
    expect(await opportunityUpdatePage.getClassificationcodeInput()).to.eq(
      'classificationcode',
      'Expected Classificationcode value to be equals to classificationcode'
    );
    expect(await opportunityUpdatePage.getPopstateInput()).to.eq('popstate', 'Expected Popstate value to be equals to popstate');
    expect(await opportunityUpdatePage.getPopzipInput()).to.eq('popzip', 'Expected Popzip value to be equals to popzip');
    expect(await opportunityUpdatePage.getPopcountryInput()).to.eq('popcountry', 'Expected Popcountry value to be equals to popcountry');
    expect(await opportunityUpdatePage.getActiveInput()).to.eq('active', 'Expected Active value to be equals to active');
    expect(await opportunityUpdatePage.getOrganizationtypeInput()).to.eq(
      'organizationtype',
      'Expected Organizationtype value to be equals to organizationtype'
    );
    expect(await opportunityUpdatePage.getDescriptionInput()).to.eq(
      'description',
      'Expected Description value to be equals to description'
    );

    await opportunityUpdatePage.save();
    expect(await opportunityUpdatePage.getSaveButton().isPresent(), 'Expected save button disappear').to.be.false;

    expect(await opportunityComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeCreate + 1, 'Expected one more entry in the table');
  });

  it('should delete last Opportunity', async () => {
    const nbButtonsBeforeDelete = await opportunityComponentsPage.countDeleteButtons();
    await opportunityComponentsPage.clickOnLastDeleteButton();

    opportunityDeleteDialog = new OpportunityDeleteDialog();
    expect(await opportunityDeleteDialog.getDialogTitle()).to.eq('Are you sure you want to delete this Opportunity?');
    await opportunityDeleteDialog.clickOnConfirmButton();

    expect(await opportunityComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
