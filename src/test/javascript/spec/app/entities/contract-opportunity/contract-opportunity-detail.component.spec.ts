import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';
import { JhiDataUtils } from 'ng-jhipster';

import { OpportunitiesTestModule } from '../../../test.module';
import { ContractOpportunityDetailComponent } from 'app/entities/contract-opportunity/contract-opportunity-detail.component';
import { ContractOpportunity } from 'app/shared/model/contract-opportunity.model';

describe('Component Tests', () => {
  describe('ContractOpportunity Management Detail Component', () => {
    let comp: ContractOpportunityDetailComponent;
    let fixture: ComponentFixture<ContractOpportunityDetailComponent>;
    let dataUtils: JhiDataUtils;
    const route = ({ data: of({ contractOpportunity: new ContractOpportunity(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OpportunitiesTestModule],
        declarations: [ContractOpportunityDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(ContractOpportunityDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(ContractOpportunityDetailComponent);
      comp = fixture.componentInstance;
      dataUtils = fixture.debugElement.injector.get(JhiDataUtils);
    });

    describe('OnInit', () => {
      it('Should load contractOpportunity on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.contractOpportunity).toEqual(jasmine.objectContaining({ id: 123 }));
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
