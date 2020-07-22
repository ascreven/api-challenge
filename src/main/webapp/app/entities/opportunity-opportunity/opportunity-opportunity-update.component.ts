import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { JhiDataUtils, JhiFileLoadError, JhiEventManager, JhiEventWithContent } from 'ng-jhipster';

import { IOpportunityOpportunity, OpportunityOpportunity } from 'app/shared/model/opportunity-opportunity.model';
import { OpportunityOpportunityService } from './opportunity-opportunity.service';
import { AlertError } from 'app/shared/alert/alert-error.model';

@Component({
  selector: 'jhi-opportunity-opportunity-update',
  templateUrl: './opportunity-opportunity-update.component.html',
})
export class OpportunityOpportunityUpdateComponent implements OnInit {
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
    protected opportunityOpportunityService: OpportunityOpportunityService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ opportunityOpportunity }) => {
      this.updateForm(opportunityOpportunity);
    });
  }

  updateForm(opportunityOpportunity: IOpportunityOpportunity): void {
    this.editForm.patchValue({
      id: opportunityOpportunity.id,
      contractId: opportunityOpportunity.contractId,
      title: opportunityOpportunity.title,
      sol: opportunityOpportunity.sol,
      agency: opportunityOpportunity.agency,
      subTier: opportunityOpportunity.subTier,
      office: opportunityOpportunity.office,
      posteddate: opportunityOpportunity.posteddate,
      type: opportunityOpportunity.type,
      basetype: opportunityOpportunity.basetype,
      setasidecode: opportunityOpportunity.setasidecode,
      setaside: opportunityOpportunity.setaside,
      responsedeadline: opportunityOpportunity.responsedeadline,
      naicscode: opportunityOpportunity.naicscode,
      classificationcode: opportunityOpportunity.classificationcode,
      popstate: opportunityOpportunity.popstate,
      popzip: opportunityOpportunity.popzip,
      popcountry: opportunityOpportunity.popcountry,
      active: opportunityOpportunity.active,
      organizationtype: opportunityOpportunity.organizationtype,
      description: opportunityOpportunity.description,
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
    const opportunityOpportunity = this.createFromForm();
    if (opportunityOpportunity.id !== undefined) {
      this.subscribeToSaveResponse(this.opportunityOpportunityService.update(opportunityOpportunity));
    } else {
      this.subscribeToSaveResponse(this.opportunityOpportunityService.create(opportunityOpportunity));
    }
  }

  private createFromForm(): IOpportunityOpportunity {
    return {
      ...new OpportunityOpportunity(),
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

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IOpportunityOpportunity>>): void {
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
