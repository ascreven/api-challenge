import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { OpportunityOpportunityService } from 'app/entities/opportunity-opportunity/opportunity-opportunity.service';
import { IOpportunityOpportunity, OpportunityOpportunity } from 'app/shared/model/opportunity-opportunity.model';

describe('Service Tests', () => {
  describe('OpportunityOpportunity Service', () => {
    let injector: TestBed;
    let service: OpportunityOpportunityService;
    let httpMock: HttpTestingController;
    let elemDefault: IOpportunityOpportunity;
    let expectedResult: IOpportunityOpportunity | IOpportunityOpportunity[] | boolean | null;
    let currentDate: moment.Moment;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(OpportunityOpportunityService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new OpportunityOpportunity(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign(
          {
            posteddate: currentDate.format(DATE_FORMAT),
            responsedeadline: currentDate.format(DATE_FORMAT),
          },
          elemDefault
        );

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a OpportunityOpportunity', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            posteddate: currentDate.format(DATE_FORMAT),
            responsedeadline: currentDate.format(DATE_FORMAT),
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            posteddate: currentDate,
            responsedeadline: currentDate,
          },
          returnedFromService
        );

        service.create(new OpportunityOpportunity()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a OpportunityOpportunity', () => {
        const returnedFromService = Object.assign(
          {
            contractId: 'BBBBBB',
            title: 'BBBBBB',
            sol: 'BBBBBB',
            agency: 'BBBBBB',
            subTier: 'BBBBBB',
            office: 'BBBBBB',
            posteddate: currentDate.format(DATE_FORMAT),
            type: 'BBBBBB',
            basetype: 'BBBBBB',
            setasidecode: 'BBBBBB',
            setaside: 'BBBBBB',
            responsedeadline: currentDate.format(DATE_FORMAT),
            naicscode: 'BBBBBB',
            classificationcode: 'BBBBBB',
            popstate: 'BBBBBB',
            popzip: 'BBBBBB',
            popcountry: 'BBBBBB',
            active: 'BBBBBB',
            organizationtype: 'BBBBBB',
            description: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            posteddate: currentDate,
            responsedeadline: currentDate,
          },
          returnedFromService
        );

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of OpportunityOpportunity', () => {
        const returnedFromService = Object.assign(
          {
            contractId: 'BBBBBB',
            title: 'BBBBBB',
            sol: 'BBBBBB',
            agency: 'BBBBBB',
            subTier: 'BBBBBB',
            office: 'BBBBBB',
            posteddate: currentDate.format(DATE_FORMAT),
            type: 'BBBBBB',
            basetype: 'BBBBBB',
            setasidecode: 'BBBBBB',
            setaside: 'BBBBBB',
            responsedeadline: currentDate.format(DATE_FORMAT),
            naicscode: 'BBBBBB',
            classificationcode: 'BBBBBB',
            popstate: 'BBBBBB',
            popzip: 'BBBBBB',
            popcountry: 'BBBBBB',
            active: 'BBBBBB',
            organizationtype: 'BBBBBB',
            description: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            posteddate: currentDate,
            responsedeadline: currentDate,
          },
          returnedFromService
        );

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a OpportunityOpportunity', () => {
        service.delete(123).subscribe(resp => (expectedResult = resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
        expect(expectedResult);
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});
