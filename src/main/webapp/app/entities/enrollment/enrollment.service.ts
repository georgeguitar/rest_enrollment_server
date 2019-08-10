import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IEnrollment } from 'app/shared/model/enrollment.model';

type EntityResponseType = HttpResponse<IEnrollment>;
type EntityArrayResponseType = HttpResponse<IEnrollment[]>;

@Injectable({ providedIn: 'root' })
export class EnrollmentService {
  public resourceUrl = SERVER_API_URL + 'api/enrollments';

  constructor(protected http: HttpClient) {}

  create(enrollment: IEnrollment): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(enrollment);
    return this.http
      .post<IEnrollment>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(enrollment: IEnrollment): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(enrollment);
    return this.http
      .put<IEnrollment>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IEnrollment>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IEnrollment[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(enrollment: IEnrollment): IEnrollment {
    const copy: IEnrollment = Object.assign({}, enrollment, {
      dateEnrollment:
        enrollment.dateEnrollment != null && enrollment.dateEnrollment.isValid() ? enrollment.dateEnrollment.format(DATE_FORMAT) : null
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.dateEnrollment = res.body.dateEnrollment != null ? moment(res.body.dateEnrollment) : null;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((enrollment: IEnrollment) => {
        enrollment.dateEnrollment = enrollment.dateEnrollment != null ? moment(enrollment.dateEnrollment) : null;
      });
    }
    return res;
  }
}
