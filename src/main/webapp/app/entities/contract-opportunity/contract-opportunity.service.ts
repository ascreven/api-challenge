import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IContractOpportunity } from 'app/shared/model/contract-opportunity.model';
import { IIndustryOpportunityCount } from 'app/shared/model/industry-opportunity-count.model';

type EntityResponseType = HttpResponse<IContractOpportunity>;
type EntityArrayResponseType = HttpResponse<IContractOpportunity[]>;

@Injectable({ providedIn: 'root' })
export class ContractOpportunityService {
  public resourceUrl = SERVER_API_URL + 'api/contract-opportunities';

  constructor(protected http: HttpClient) {}

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IContractOpportunity>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IContractOpportunity[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  countIndustryOpps(industryOppParams?: any): Observable<IIndustryOpportunityCount[]> {
    return this.http
      .get<IIndustryOpportunityCount[]>(this.resourceUrl + '/industry_opp_counts', { params: industryOppParams })
      .pipe(
        map(res => {
          return res;
        })
      );
  }

  protected convertDateFromClient(contractOpportunity: IContractOpportunity): IContractOpportunity {
    const copy: IContractOpportunity = Object.assign({}, contractOpportunity, {
      posteddate:
        contractOpportunity.posteddate && contractOpportunity.posteddate.isValid()
          ? contractOpportunity.posteddate.format(DATE_FORMAT)
          : undefined,
      responsedeadline:
        contractOpportunity.responsedeadline && contractOpportunity.responsedeadline.isValid()
          ? contractOpportunity.responsedeadline.format(DATE_FORMAT)
          : undefined,
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.posteddate = res.body.posteddate ? moment(res.body.posteddate) : undefined;
      res.body.responsedeadline = res.body.responsedeadline ? moment(res.body.responsedeadline) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((contractOpportunity: IContractOpportunity) => {
        contractOpportunity.posteddate = contractOpportunity.posteddate ? moment(contractOpportunity.posteddate) : undefined;
        contractOpportunity.responsedeadline = contractOpportunity.responsedeadline
          ? moment(contractOpportunity.responsedeadline)
          : undefined;
      });
    }
    return res;
  }
}
