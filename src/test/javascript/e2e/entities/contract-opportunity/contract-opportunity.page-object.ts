import { element, by, ElementFinder } from 'protractor';

export class ContractOpportunityComponentsPage {
  createButton = element(by.id('jh-create-entity'));
  deleteButtons = element.all(by.css('jhi-contract-opportunity div table .btn-danger'));
  title = element.all(by.css('jhi-contract-opportunity div h2#page-heading span')).first();
  noResult = element(by.id('no-result'));
  entities = element(by.id('entities'));

  async clickOnCreateButton(): Promise<void> {
    await this.createButton.click();
  }

  async clickOnLastDeleteButton(): Promise<void> {
    await this.deleteButtons.last().click();
  }

  async countDeleteButtons(): Promise<number> {
    return this.deleteButtons.count();
  }

  async getTitle(): Promise<string> {
    return this.title.getText();
  }
}

export class ContractOpportunityUpdatePage {
  pageTitle = element(by.id('jhi-contract-opportunity-heading'));
  saveButton = element(by.id('save-entity'));
  cancelButton = element(by.id('cancel-save'));

  contractIdInput = element(by.id('field_contractId'));
  titleInput = element(by.id('field_title'));
  solInput = element(by.id('field_sol'));
  agencyInput = element(by.id('field_agency'));
  subTierInput = element(by.id('field_subTier'));
  officeInput = element(by.id('field_office'));
  posteddateInput = element(by.id('field_posteddate'));
  typeInput = element(by.id('field_type'));
  basetypeInput = element(by.id('field_basetype'));
  setasidecodeInput = element(by.id('field_setasidecode'));
  setasideInput = element(by.id('field_setaside'));
  responsedeadlineInput = element(by.id('field_responsedeadline'));
  naicscodeInput = element(by.id('field_naicscode'));
  classificationcodeInput = element(by.id('field_classificationcode'));
  popstateInput = element(by.id('field_popstate'));
  popzipInput = element(by.id('field_popzip'));
  popcountryInput = element(by.id('field_popcountry'));
  activeInput = element(by.id('field_active'));
  organizationtypeInput = element(by.id('field_organizationtype'));
  descriptionInput = element(by.id('field_description'));

  async getPageTitle(): Promise<string> {
    return this.pageTitle.getText();
  }

  async setContractIdInput(contractId: string): Promise<void> {
    await this.contractIdInput.sendKeys(contractId);
  }

  async getContractIdInput(): Promise<string> {
    return await this.contractIdInput.getAttribute('value');
  }

  async setTitleInput(title: string): Promise<void> {
    await this.titleInput.sendKeys(title);
  }

  async getTitleInput(): Promise<string> {
    return await this.titleInput.getAttribute('value');
  }

  async setSolInput(sol: string): Promise<void> {
    await this.solInput.sendKeys(sol);
  }

  async getSolInput(): Promise<string> {
    return await this.solInput.getAttribute('value');
  }

  async setAgencyInput(agency: string): Promise<void> {
    await this.agencyInput.sendKeys(agency);
  }

  async getAgencyInput(): Promise<string> {
    return await this.agencyInput.getAttribute('value');
  }

  async setSubTierInput(subTier: string): Promise<void> {
    await this.subTierInput.sendKeys(subTier);
  }

  async getSubTierInput(): Promise<string> {
    return await this.subTierInput.getAttribute('value');
  }

  async setOfficeInput(office: string): Promise<void> {
    await this.officeInput.sendKeys(office);
  }

  async getOfficeInput(): Promise<string> {
    return await this.officeInput.getAttribute('value');
  }

  async setPosteddateInput(posteddate: string): Promise<void> {
    await this.posteddateInput.sendKeys(posteddate);
  }

  async getPosteddateInput(): Promise<string> {
    return await this.posteddateInput.getAttribute('value');
  }

  async setTypeInput(type: string): Promise<void> {
    await this.typeInput.sendKeys(type);
  }

  async getTypeInput(): Promise<string> {
    return await this.typeInput.getAttribute('value');
  }

  async setBasetypeInput(basetype: string): Promise<void> {
    await this.basetypeInput.sendKeys(basetype);
  }

  async getBasetypeInput(): Promise<string> {
    return await this.basetypeInput.getAttribute('value');
  }

  async setSetasidecodeInput(setasidecode: string): Promise<void> {
    await this.setasidecodeInput.sendKeys(setasidecode);
  }

  async getSetasidecodeInput(): Promise<string> {
    return await this.setasidecodeInput.getAttribute('value');
  }

  async setSetasideInput(setaside: string): Promise<void> {
    await this.setasideInput.sendKeys(setaside);
  }

  async getSetasideInput(): Promise<string> {
    return await this.setasideInput.getAttribute('value');
  }

  async setResponsedeadlineInput(responsedeadline: string): Promise<void> {
    await this.responsedeadlineInput.sendKeys(responsedeadline);
  }

  async getResponsedeadlineInput(): Promise<string> {
    return await this.responsedeadlineInput.getAttribute('value');
  }

  async setNaicscodeInput(naicscode: string): Promise<void> {
    await this.naicscodeInput.sendKeys(naicscode);
  }

  async getNaicscodeInput(): Promise<string> {
    return await this.naicscodeInput.getAttribute('value');
  }

  async setClassificationcodeInput(classificationcode: string): Promise<void> {
    await this.classificationcodeInput.sendKeys(classificationcode);
  }

  async getClassificationcodeInput(): Promise<string> {
    return await this.classificationcodeInput.getAttribute('value');
  }

  async setPopstateInput(popstate: string): Promise<void> {
    await this.popstateInput.sendKeys(popstate);
  }

  async getPopstateInput(): Promise<string> {
    return await this.popstateInput.getAttribute('value');
  }

  async setPopzipInput(popzip: string): Promise<void> {
    await this.popzipInput.sendKeys(popzip);
  }

  async getPopzipInput(): Promise<string> {
    return await this.popzipInput.getAttribute('value');
  }

  async setPopcountryInput(popcountry: string): Promise<void> {
    await this.popcountryInput.sendKeys(popcountry);
  }

  async getPopcountryInput(): Promise<string> {
    return await this.popcountryInput.getAttribute('value');
  }

  async setActiveInput(active: string): Promise<void> {
    await this.activeInput.sendKeys(active);
  }

  async getActiveInput(): Promise<string> {
    return await this.activeInput.getAttribute('value');
  }

  async setOrganizationtypeInput(organizationtype: string): Promise<void> {
    await this.organizationtypeInput.sendKeys(organizationtype);
  }

  async getOrganizationtypeInput(): Promise<string> {
    return await this.organizationtypeInput.getAttribute('value');
  }

  async setDescriptionInput(description: string): Promise<void> {
    await this.descriptionInput.sendKeys(description);
  }

  async getDescriptionInput(): Promise<string> {
    return await this.descriptionInput.getAttribute('value');
  }

  async save(): Promise<void> {
    await this.saveButton.click();
  }

  async cancel(): Promise<void> {
    await this.cancelButton.click();
  }

  getSaveButton(): ElementFinder {
    return this.saveButton;
  }
}

export class ContractOpportunityDeleteDialog {
  private dialogTitle = element(by.id('jhi-delete-contractOpportunity-heading'));
  private confirmButton = element(by.id('jhi-confirm-delete-contractOpportunity'));

  async getDialogTitle(): Promise<string> {
    return this.dialogTitle.getText();
  }

  async clickOnConfirmButton(): Promise<void> {
    await this.confirmButton.click();
  }
}
