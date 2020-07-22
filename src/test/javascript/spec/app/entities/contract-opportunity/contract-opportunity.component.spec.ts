import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { OpportunitiesTestModule } from '../../../test.module';
import { ContractOpportunityComponent } from 'app/entities/contract-opportunity/contract-opportunity.component';
import { ContractOpportunityService } from 'app/entities/contract-opportunity/contract-opportunity.service';
import { ContractOpportunity } from 'app/shared/model/contract-opportunity.model';

describe('Component Tests', () => {
  describe('ContractOpportunity Management Component', () => {
    let comp: ContractOpportunityComponent;
    let fixture: ComponentFixture<ContractOpportunityComponent>;
    let service: ContractOpportunityService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OpportunitiesTestModule],
        declarations: [ContractOpportunityComponent],
      })
        .overrideTemplate(ContractOpportunityComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(ContractOpportunityComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(ContractOpportunityService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new ContractOpportunity(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.contractOpportunities && comp.contractOpportunities[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
