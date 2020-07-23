import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';
import { JhiDataUtils } from 'ng-jhipster';

import { OpportunitiesTestModule } from '../../../test.module';
import { NaicsDetailComponent } from 'app/entities/naics/naics-detail.component';
import { Naics } from 'app/shared/model/naics.model';

describe('Component Tests', () => {
  describe('Naics Management Detail Component', () => {
    let comp: NaicsDetailComponent;
    let fixture: ComponentFixture<NaicsDetailComponent>;
    let dataUtils: JhiDataUtils;
    const route = ({ data: of({ naics: new Naics(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OpportunitiesTestModule],
        declarations: [NaicsDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(NaicsDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(NaicsDetailComponent);
      comp = fixture.componentInstance;
      dataUtils = fixture.debugElement.injector.get(JhiDataUtils);
    });

    describe('OnInit', () => {
      it('Should load naics on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.naics).toEqual(jasmine.objectContaining({ id: 123 }));
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
