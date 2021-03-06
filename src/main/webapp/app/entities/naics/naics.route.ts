import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { INaics, Naics } from 'app/shared/model/naics.model';
import { NaicsService } from './naics.service';
import { NaicsComponent } from './naics.component';
import { NaicsDetailComponent } from './naics-detail.component';

@Injectable({ providedIn: 'root' })
export class NaicsResolve implements Resolve<INaics> {
  constructor(private service: NaicsService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<INaics> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((naics: HttpResponse<Naics>) => {
          if (naics.body) {
            return of(naics.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new Naics());
  }
}

export const naicsRoute: Routes = [
  {
    path: '',
    component: NaicsComponent,
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'Naics',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: NaicsDetailComponent,
    resolve: {
      naics: NaicsResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'Naics',
    },
    canActivate: [UserRouteAccessService],
  },
];
