import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';
import { JhiDataUtils } from 'ng-jhipster';

import { OpportunitiesTestModule } from '../../../test.module';
import { OpportunityOpportunityDetailComponent } from 'app/entities/opportunity-opportunity/opportunity-opportunity-detail.component';
import { OpportunityOpportunity } from 'app/shared/model/opportunity-opportunity.model';

describe('Component Tests', () => {
  describe('OpportunityOpportunity Management Detail Component', () => {
    let comp: OpportunityOpportunityDetailComponent;
    let fixture: ComponentFixture<OpportunityOpportunityDetailComponent>;
    let dataUtils: JhiDataUtils;
    const route = ({ data: of({ opportunityOpportunity: new OpportunityOpportunity(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OpportunitiesTestModule],
        declarations: [OpportunityOpportunityDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(OpportunityOpportunityDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(OpportunityOpportunityDetailComponent);
      comp = fixture.componentInstance;
      dataUtils = fixture.debugElement.injector.get(JhiDataUtils);
    });

    describe('OnInit', () => {
      it('Should load opportunityOpportunity on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.opportunityOpportunity).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });

    describe('byteSize', () => {
      it('Should call byteSize from JhiDataUtils', () => {
        // GIVEN
        spyOn(dataUtils, 'byteSize');
        const fakeBase64 = 'fake base64';

        // WHEN
        comp.byteSize(fakeBase64);

        // THEN
        expect(dataUtils.byteSize).toBeCalledWith(fakeBase64);
      });
    });

    describe('openFile', () => {
      it('Should call openFile from JhiDataUtils', () => {
        // GIVEN
        spyOn(dataUtils, 'openFile');
        const fakeContentType = 'fake content type';
        const fakeBase64 = 'fake base64';

        // WHEN
        comp.openFile(fakeContentType, fakeBase64);

        // THEN
        expect(dataUtils.openFile).toBeCalledWith(fakeContentType, fakeBase64);
      });
    });
  });
});
