import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { OpportunitiesTestModule } from '../../../test.module';
import { MockEventManager } from '../../../helpers/mock-event-manager.service';
import { MockActiveModal } from '../../../helpers/mock-active-modal.service';
import { ContractOpportunityDeleteDialogComponent } from 'app/entities/contract-opportunity/contract-opportunity-delete-dialog.component';
import { ContractOpportunityService } from 'app/entities/contract-opportunity/contract-opportunity.service';

describe('Component Tests', () => {
  describe('ContractOpportunity Management Delete Component', () => {
    let comp: ContractOpportunityDeleteDialogComponent;
    let fixture: ComponentFixture<ContractOpportunityDeleteDialogComponent>;
    let service: ContractOpportunityService;
    let mockEventManager: MockEventManager;
    let mockActiveModal: MockActiveModal;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OpportunitiesTestModule],
        declarations: [ContractOpportunityDeleteDialogComponent],
      })
        .overrideTemplate(ContractOpportunityDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(ContractOpportunityDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(ContractOpportunityService);
      mockEventManager = TestBed.get(JhiEventManager);
      mockActiveModal = TestBed.get(NgbActiveModal);
    });

    describe('confirmDelete', () => {
      it('Should call delete service on confirmDelete', inject(
        [],
        fakeAsync(() => {
          // GIVEN
          spyOn(service, 'delete').and.returnValue(of({}));

          // WHEN
          comp.confirmDelete(123);
          tick();

          // THEN
          expect(service.delete).toHaveBeenCalledWith(123);
          expect(mockActiveModal.closeSpy).toHaveBeenCalled();
          expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
        })
      ));

      it('Should not call delete service on clear', () => {
        // GIVEN
        spyOn(service, 'delete');

        // WHEN
        comp.cancel();

        // THEN
        expect(service.delete).not.toHaveBeenCalled();
        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
      });
    });
  });
});
