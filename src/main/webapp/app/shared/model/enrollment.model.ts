import { Moment } from 'moment';
import { IStudent } from 'app/shared/model/student.model';
import { IProgram } from 'app/shared/model/program.model';

export interface IEnrollment {
  id?: number;
  year?: string;
  period?: string;
  level?: string;
  dateEnrollment?: Moment;
  student?: IStudent;
  program?: IProgram;
}

export class Enrollment implements IEnrollment {
  constructor(
    public id?: number,
    public year?: string,
    public period?: string,
    public level?: string,
    public dateEnrollment?: Moment,
    public student?: IStudent,
    public program?: IProgram
  ) {}
}
