import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { OpportunitiesTestModule } from '../../../test.module';
import { OpportunityOpportunityUpdateComponent } from 'app/entities/opportunity-opportunity/opportunity-opportunity-update.component';
import { OpportunityOpportunityService } from 'app/entities/opportunity-opportunity/opportunity-opportunity.service';
import { OpportunityOpportunity } from 'app/shared/model/opportunity-opportunity.model';

describe('Component Tests', () => {
  describe('OpportunityOpportunity Management Update Component', () => {
    let comp: OpportunityOpportunityUpdateComponent;
    let fixture: ComponentFixture<OpportunityOpportunityUpdateComponent>;
    let service: OpportunityOpportunityService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OpportunitiesTestModule],
        declarations: [OpportunityOpportunityUpdateComponent],
        providers: [FormBuilder],
      })
        .overrideTemplate(OpportunityOpportunityUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(OpportunityOpportunityUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(OpportunityOpportunityService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new OpportunityOpportunity(123);
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
        const entity = new OpportunityOpportunity();
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
