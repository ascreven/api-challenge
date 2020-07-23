import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { INaics } from 'app/shared/model/naics.model';

type EntityResponseType = HttpResponse<INaics>;
type EntityArrayResponseType = HttpResponse<INaics[]>;

@Injectable({ providedIn: 'root' })
export class NaicsService {
  public resourceUrl = SERVER_API_URL + 'api/naics';

  constructor(protected http: HttpClient) {}

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<INaics>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<INaics[]>(this.resourceUrl, { params: options, observe: 'response' });
  }
}
