import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { OpportunitiesTestModule } from '../../../test.module';
import { ContractOpportunityUpdateComponent } from 'app/entities/contract-opportunity/contract-opportunity-update.component';
import { ContractOpportunityService } from 'app/entities/contract-opportunity/contract-opportunity.service';
import { ContractOpportunity } from 'app/shared/model/contract-opportunity.model';

describe('Component Tests', () => {
  describe('ContractOpportunity Management Update Component', () => {
    let comp: ContractOpportunityUpdateComponent;
    let fixture: ComponentFixture<ContractOpportunityUpdateComponent>;
    let service: ContractOpportunityService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OpportunitiesTestModule],
        declarations: [ContractOpportunityUpdateComponent],
        providers: [FormBuilder],
      })
        .overrideTemplate(ContractOpportunityUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(ContractOpportunityUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(ContractOpportunityService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new ContractOpportunity(123);
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new ContractOpportunity();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});
