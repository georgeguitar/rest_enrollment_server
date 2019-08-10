import { IEnrollment } from 'app/shared/model/enrollment.model';

export const enum Semesters {
  FIRST = 'FIRST',
  SECOND = 'SECOND',
  THIRD = 'THIRD',
  FOURTH = 'FOURTH',
  FIFTH = 'FIFTH',
  SIXTH = 'SIXTH',
  SEVENTH = 'SEVENTH',
  EIGHTH = 'EIGHTH',
  NINTH = 'NINTH',
  TENTH = 'TENTH'
}

export interface IProgram {
  id?: number;
  name?: string;
  semesters?: Semesters;
  title?: string;
  credits?: number;
  enrollments?: IEnrollment[];
}

export class Program implements IProgram {
  constructor(
    public id?: number,
    public name?: string,
    public semesters?: Semesters,
    public title?: string,
    public credits?: number,
    public enrollments?: IEnrollment[]
  ) {}
}
