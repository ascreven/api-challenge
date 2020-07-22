import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { OpportunitiesTestModule } from '../../../test.module';
import { OpportunityOpportunityComponent } from 'app/entities/opportunity-opportunity/opportunity-opportunity.component';
import { OpportunityOpportunityService } from 'app/entities/opportunity-opportunity/opportunity-opportunity.service';
import { OpportunityOpportunity } from 'app/shared/model/opportunity-opportunity.model';

describe('Component Tests', () => {
  describe('OpportunityOpportunity Management Component', () => {
    let comp: OpportunityOpportunityComponent;
    let fixture: ComponentFixture<OpportunityOpportunityComponent>;
    let service: OpportunityOpportunityService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OpportunitiesTestModule],
        declarations: [OpportunityOpportunityComponent],
      })
        .overrideTemplate(OpportunityOpportunityComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(OpportunityOpportunityComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(OpportunityOpportunityService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new OpportunityOpportunity(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.opportunityOpportunities && comp.opportunityOpportunities[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
