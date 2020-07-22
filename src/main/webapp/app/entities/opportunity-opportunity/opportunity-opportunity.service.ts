import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IOpportunityOpportunity } from 'app/shared/model/opportunity-opportunity.model';

type EntityResponseType = HttpResponse<IOpportunityOpportunity>;
type EntityArrayResponseType = HttpResponse<IOpportunityOpportunity[]>;

@Injectable({ providedIn: 'root' })
export class OpportunityOpportunityService {
  public resourceUrl = SERVER_API_URL + 'api/opportunity-opportunities';

  constructor(protected http: HttpClient) {}

  create(opportunityOpportunity: IOpportunityOpportunity): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(opportunityOpportunity);
    return this.http
      .post<IOpportunityOpportunity>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(opportunityOpportunity: IOpportunityOpportunity): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(opportunityOpportunity);
    return this.http
      .put<IOpportunityOpportunity>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IOpportunityOpportunity>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IOpportunityOpportunity[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(opportunityOpportunity: IOpportunityOpportunity): IOpportunityOpportunity {
    const copy: IOpportunityOpportunity = Object.assign({}, opportunityOpportunity, {
      posteddate:
        opportunityOpportunity.posteddate && opportunityOpportunity.posteddate.isValid()
          ? opportunityOpportunity.posteddate.format(DATE_FORMAT)
          : undefined,
      responsedeadline:
        opportunityOpportunity.responsedeadline && opportunityOpportunity.responsedeadline.isValid()
          ? opportunityOpportunity.responsedeadline.format(DATE_FORMAT)
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
      res.body.forEach((opportunityOpportunity: IOpportunityOpportunity) => {
        opportunityOpportunity.posteddate = opportunityOpportunity.posteddate ? moment(opportunityOpportunity.posteddate) : undefined;
        opportunityOpportunity.responsedeadline = opportunityOpportunity.responsedeadline
          ? moment(opportunityOpportunity.responsedeadline)
          : undefined;
      });
    }
    return res;
  }
}
