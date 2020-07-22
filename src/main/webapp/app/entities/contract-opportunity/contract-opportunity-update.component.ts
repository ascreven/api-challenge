import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { JhiDataUtils, JhiFileLoadError, JhiEventManager, JhiEventWithContent } from 'ng-jhipster';

import { IContractOpportunity, ContractOpportunity } from 'app/shared/model/contract-opportunity.model';
import { ContractOpportunityService } from './contract-opportunity.service';
import { AlertError } from 'app/shared/alert/alert-error.model';

@Component({
  selector: 'jhi-contract-opportunity-update',
  templateUrl: './contract-opportunity-update.component.html',
})
export class ContractOpportunityUpdateComponent implements OnInit {
  isSaving = false;
  posteddateDp: any;
  responsedeadlineDp: any;

  editForm = this.fb.group({
    id: [],
    contractId: [],
    title: [null, [Validators.maxLength(1024)]],
    sol: [],
    agency: [],
    subTier: [],
    office: [],
    posteddate: [],
    type: [],
    basetype: [],
    setasidecode: [],
    setaside: [],
    responsedeadline: [],
    naicscode: [],
    classificationcode: [],
    popstate: [],
    popzip: [],
    popcountry: [],
    active: [],
    organizationtype: [],
    description: [],
  });

  constructor(
    protected dataUtils: JhiDataUtils,
    protected eventManager: JhiEventManager,
    protected contractOpportunityService: ContractOpportunityService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ contractOpportunity }) => {
      this.updateForm(contractOpportunity);
    });
  }

  updateForm(contractOpportunity: IContractOpportunity): void {
    this.editForm.patchValue({
      id: contractOpportunity.id,
      contractId: contractOpportunity.contractId,
      title: contractOpportunity.title,
      sol: contractOpportunity.sol,
      agency: contractOpportunity.agency,
      subTier: contractOpportunity.subTier,
      office: contractOpportunity.office,
      posteddate: contractOpportunity.posteddate,
      type: contractOpportunity.type,
      basetype: contractOpportunity.basetype,
      setasidecode: contractOpportunity.setasidecode,
      setaside: contractOpportunity.setaside,
      responsedeadline: contractOpportunity.responsedeadline,
      naicscode: contractOpportunity.naicscode,
      classificationcode: contractOpportunity.classificationcode,
      popstate: contractOpportunity.popstate,
      popzip: contractOpportunity.popzip,
      popcountry: contractOpportunity.popcountry,
      active: contractOpportunity.active,
      organizationtype: contractOpportunity.organizationtype,
      description: contractOpportunity.description,
    });
  }

  byteSize(base64String: string): string {
    return this.dataUtils.byteSize(base64String);
  }

  openFile(contentType: string, base64String: string): void {
    this.dataUtils.openFile(contentType, base64String);
  }

  setFileData(event: Event, field: string, isImage: boolean): void {
    this.dataUtils.loadFileToForm(event, this.editForm, field, isImage).subscribe(null, (err: JhiFileLoadError) => {
      this.eventManager.broadcast(
        new JhiEventWithContent<AlertError>('opportunitiesApp.error', { message: err.message })
      );
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const contractOpportunity = this.createFromForm();
    if (contractOpportunity.id !== undefined) {
      this.subscribeToSaveResponse(this.contractOpportunityService.update(contractOpportunity));
    } else {
      this.subscribeToSaveResponse(this.contractOpportunityService.create(contractOpportunity));
    }
  }

  private createFromForm(): IContractOpportunity {
    return {
      ...new ContractOpportunity(),
      id: this.editForm.get(['id'])!.value,
      contractId: this.editForm.get(['contractId'])!.value,
      title: this.editForm.get(['title'])!.value,
      sol: this.editForm.get(['sol'])!.value,
      agency: this.editForm.get(['agency'])!.value,
      subTier: this.editForm.get(['subTier'])!.value,
      office: this.editForm.get(['office'])!.value,
      posteddate: this.editForm.get(['posteddate'])!.value,
      type: this.editForm.get(['type'])!.value,
      basetype: this.editForm.get(['basetype'])!.value,
      setasidecode: this.editForm.get(['setasidecode'])!.value,
      setaside: this.editForm.get(['setaside'])!.value,
      responsedeadline: this.editForm.get(['responsedeadline'])!.value,
      naicscode: this.editForm.get(['naicscode'])!.value,
      classificationcode: this.editForm.get(['classificationcode'])!.value,
      popstate: this.editForm.get(['popstate'])!.value,
      popzip: this.editForm.get(['popzip'])!.value,
      popcountry: this.editForm.get(['popcountry'])!.value,
      active: this.editForm.get(['active'])!.value,
      organizationtype: this.editForm.get(['organizationtype'])!.value,
      description: this.editForm.get(['description'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IContractOpportunity>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}
