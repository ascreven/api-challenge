import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { ContractOpportunityService } from 'app/entities/contract-opportunity/contract-opportunity.service';
import { IContractOpportunity, ContractOpportunity } from 'app/shared/model/contract-opportunity.model';

describe('Service Tests', () => {
  describe('ContractOpportunity Service', () => {
    let injector: TestBed;
    let service: ContractOpportunityService;
    let httpMock: HttpTestingController;
    let elemDefault: IContractOpportunity;
    let expectedResult: IContractOpportunity | IContractOpportunity[] | boolean | null;
    let currentDate: moment.Moment;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(ContractOpportunityService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new ContractOpportunity(
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

      it('should return a list of ContractOpportunity', () => {
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
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});
