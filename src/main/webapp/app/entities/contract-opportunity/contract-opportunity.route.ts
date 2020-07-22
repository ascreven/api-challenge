import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IContractOpportunity, ContractOpportunity } from 'app/shared/model/contract-opportunity.model';
import { ContractOpportunityService } from './contract-opportunity.service';
import { ContractOpportunityComponent } from './contract-opportunity.component';
import { ContractOpportunityDetailComponent } from './contract-opportunity-detail.component';

@Injectable({ providedIn: 'root' })
export class ContractOpportunityResolve implements Resolve<IContractOpportunity> {
  constructor(private service: ContractOpportunityService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IContractOpportunity> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((contractOpportunity: HttpResponse<ContractOpportunity>) => {
          if (contractOpportunity.body) {
            return of(contractOpportunity.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new ContractOpportunity());
  }
}

export const contractOpportunityRoute: Routes = [
  {
    path: '',
    component: ContractOpportunityComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'ContractOpportunities',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: ContractOpportunityDetailComponent,
    resolve: {
      contractOpportunity: ContractOpportunityResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'ContractOpportunities',
    },
    canActivate: [UserRouteAccessService],
  },
];
