import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IOpportunityOpportunity, OpportunityOpportunity } from 'app/shared/model/opportunity-opportunity.model';
import { OpportunityOpportunityService } from './opportunity-opportunity.service';
import { OpportunityOpportunityComponent } from './opportunity-opportunity.component';
import { OpportunityOpportunityDetailComponent } from './opportunity-opportunity-detail.component';
import { OpportunityOpportunityUpdateComponent } from './opportunity-opportunity-update.component';

@Injectable({ providedIn: 'root' })
export class OpportunityOpportunityResolve implements Resolve<IOpportunityOpportunity> {
  constructor(private service: OpportunityOpportunityService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IOpportunityOpportunity> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((opportunityOpportunity: HttpResponse<OpportunityOpportunity>) => {
          if (opportunityOpportunity.body) {
            return of(opportunityOpportunity.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new OpportunityOpportunity());
  }
}

export const opportunityOpportunityRoute: Routes = [
  {
    path: '',
    component: OpportunityOpportunityComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'OpportunityOpportunities',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: OpportunityOpportunityDetailComponent,
    resolve: {
      opportunityOpportunity: OpportunityOpportunityResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'OpportunityOpportunities',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: OpportunityOpportunityUpdateComponent,
    resolve: {
      opportunityOpportunity: OpportunityOpportunityResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'OpportunityOpportunities',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: OpportunityOpportunityUpdateComponent,
    resolve: {
      opportunityOpportunity: OpportunityOpportunityResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'OpportunityOpportunities',
    },
    canActivate: [UserRouteAccessService],
  },
];
