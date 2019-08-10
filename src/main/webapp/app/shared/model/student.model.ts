import { IEnrollment } from 'app/shared/model/enrollment.model';

export interface IStudent {
  id?: number;
  name?: string;
  surname?: string;
  address?: string;
  telephone?: string;
  enrollments?: IEnrollment[];
}

export class Student implements IStudent {
  constructor(
    public id?: number,
    public name?: string,
    public surname?: string,
    public address?: string,
    public telephone?: string,
    public enrollments?: IEnrollment[]
  ) {}
}
