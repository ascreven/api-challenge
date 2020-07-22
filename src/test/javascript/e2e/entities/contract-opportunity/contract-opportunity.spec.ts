import { browser, ExpectedConditions as ec, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

import {
  ContractOpportunityComponentsPage,
  ContractOpportunityDeleteDialog,
  ContractOpportunityUpdatePage,
} from './contract-opportunity.page-object';

const expect = chai.expect;

describe('ContractOpportunity e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let contractOpportunityComponentsPage: ContractOpportunityComponentsPage;
  let contractOpportunityUpdatePage: ContractOpportunityUpdatePage;
  let contractOpportunityDeleteDialog: ContractOpportunityDeleteDialog;

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

  it('should load create ContractOpportunity page', async () => {
    await contractOpportunityComponentsPage.clickOnCreateButton();
    contractOpportunityUpdatePage = new ContractOpportunityUpdatePage();
    expect(await contractOpportunityUpdatePage.getPageTitle()).to.eq('Create or edit a Contract Opportunity');
    await contractOpportunityUpdatePage.cancel();
  });

  it('should create and save ContractOpportunities', async () => {
    const nbButtonsBeforeCreate = await contractOpportunityComponentsPage.countDeleteButtons();

    await contractOpportunityComponentsPage.clickOnCreateButton();

    await promise.all([
      contractOpportunityUpdatePage.setContractIdInput('contractId'),
      contractOpportunityUpdatePage.setTitleInput('title'),
      contractOpportunityUpdatePage.setSolInput('sol'),
      contractOpportunityUpdatePage.setAgencyInput('agency'),
      contractOpportunityUpdatePage.setSubTierInput('subTier'),
      contractOpportunityUpdatePage.setOfficeInput('office'),
      contractOpportunityUpdatePage.setPosteddateInput('2000-12-31'),
      contractOpportunityUpdatePage.setTypeInput('type'),
      contractOpportunityUpdatePage.setBasetypeInput('basetype'),
      contractOpportunityUpdatePage.setSetasidecodeInput('setasidecode'),
      contractOpportunityUpdatePage.setSetasideInput('setaside'),
      contractOpportunityUpdatePage.setResponsedeadlineInput('2000-12-31'),
      contractOpportunityUpdatePage.setNaicscodeInput('naicscode'),
      contractOpportunityUpdatePage.setClassificationcodeInput('classificationcode'),
      contractOpportunityUpdatePage.setPopstateInput('popstate'),
      contractOpportunityUpdatePage.setPopzipInput('popzip'),
      contractOpportunityUpdatePage.setPopcountryInput('popcountry'),
      contractOpportunityUpdatePage.setActiveInput('active'),
      contractOpportunityUpdatePage.setOrganizationtypeInput('organizationtype'),
      contractOpportunityUpdatePage.setDescriptionInput('description'),
    ]);

    expect(await contractOpportunityUpdatePage.getContractIdInput()).to.eq(
      'contractId',
      'Expected ContractId value to be equals to contractId'
    );
    expect(await contractOpportunityUpdatePage.getTitleInput()).to.eq('title', 'Expected Title value to be equals to title');
    expect(await contractOpportunityUpdatePage.getSolInput()).to.eq('sol', 'Expected Sol value to be equals to sol');
    expect(await contractOpportunityUpdatePage.getAgencyInput()).to.eq('agency', 'Expected Agency value to be equals to agency');
    expect(await contractOpportunityUpdatePage.getSubTierInput()).to.eq('subTier', 'Expected SubTier value to be equals to subTier');
    expect(await contractOpportunityUpdatePage.getOfficeInput()).to.eq('office', 'Expected Office value to be equals to office');
    expect(await contractOpportunityUpdatePage.getPosteddateInput()).to.eq(
      '2000-12-31',
      'Expected posteddate value to be equals to 2000-12-31'
    );
    expect(await contractOpportunityUpdatePage.getTypeInput()).to.eq('type', 'Expected Type value to be equals to type');
    expect(await contractOpportunityUpdatePage.getBasetypeInput()).to.eq('basetype', 'Expected Basetype value to be equals to basetype');
    expect(await contractOpportunityUpdatePage.getSetasidecodeInput()).to.eq(
      'setasidecode',
      'Expected Setasidecode value to be equals to setasidecode'
    );
    expect(await contractOpportunityUpdatePage.getSetasideInput()).to.eq('setaside', 'Expected Setaside value to be equals to setaside');
    expect(await contractOpportunityUpdatePage.getResponsedeadlineInput()).to.eq(
      '2000-12-31',
      'Expected responsedeadline value to be equals to 2000-12-31'
    );
    expect(await contractOpportunityUpdatePage.getNaicscodeInput()).to.eq(
      'naicscode',
      'Expected Naicscode value to be equals to naicscode'
    );
    expect(await contractOpportunityUpdatePage.getClassificationcodeInput()).to.eq(
      'classificationcode',
      'Expected Classificationcode value to be equals to classificationcode'
    );
    expect(await contractOpportunityUpdatePage.getPopstateInput()).to.eq('popstate', 'Expected Popstate value to be equals to popstate');
    expect(await contractOpportunityUpdatePage.getPopzipInput()).to.eq('popzip', 'Expected Popzip value to be equals to popzip');
    expect(await contractOpportunityUpdatePage.getPopcountryInput()).to.eq(
      'popcountry',
      'Expected Popcountry value to be equals to popcountry'
    );
    expect(await contractOpportunityUpdatePage.getActiveInput()).to.eq('active', 'Expected Active value to be equals to active');
    expect(await contractOpportunityUpdatePage.getOrganizationtypeInput()).to.eq(
      'organizationtype',
      'Expected Organizationtype value to be equals to organizationtype'
    );
    expect(await contractOpportunityUpdatePage.getDescriptionInput()).to.eq(
      'description',
      'Expected Description value to be equals to description'
    );

    await contractOpportunityUpdatePage.save();
    expect(await contractOpportunityUpdatePage.getSaveButton().isPresent(), 'Expected save button disappear').to.be.false;

    expect(await contractOpportunityComponentsPage.countDeleteButtons()).to.eq(
      nbButtonsBeforeCreate + 1,
      'Expected one more entry in the table'
    );
  });

  it('should delete last ContractOpportunity', async () => {
    const nbButtonsBeforeDelete = await contractOpportunityComponentsPage.countDeleteButtons();
    await contractOpportunityComponentsPage.clickOnLastDeleteButton();

    contractOpportunityDeleteDialog = new ContractOpportunityDeleteDialog();
    expect(await contractOpportunityDeleteDialog.getDialogTitle()).to.eq('Are you sure you want to delete this Contract Opportunity?');
    await contractOpportunityDeleteDialog.clickOnConfirmButton();

    expect(await contractOpportunityComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
