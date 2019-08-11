import { Component, OnInit } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import * as moment from 'moment';
import { JhiAlertService } from 'ng-jhipster';
import { IEnrollment, Enrollment } from 'app/shared/model/enrollment.model';
import { EnrollmentService } from './enrollment.service';
import { IStudent } from 'app/shared/model/student.model';
import { StudentService } from 'app/entities/student';
import { IProgram } from 'app/shared/model/program.model';
import { ProgramService } from 'app/entities/program';

@Component({
  selector: 'jhi-enrollment-update',
  templateUrl: './enrollment-update.component.html'
})
export class EnrollmentUpdateComponent implements OnInit {
  isSaving: boolean;

  students: IStudent[];

  programs: IProgram[];
  dateEnrollmentDp: any;

  editForm = this.fb.group({
    id: [],
    year: [null, [Validators.required, Validators.minLength(1), Validators.maxLength(60)]],
    period: [null, [Validators.required, Validators.minLength(1), Validators.maxLength(60)]],
    level: [null, [Validators.required, Validators.minLength(1), Validators.maxLength(60)]],
    dateEnrollment: [null, [Validators.required]],
    student: [null, Validators.required],
    program: [null, Validators.required]
  });

  constructor(
    protected jhiAlertService: JhiAlertService,
    protected enrollmentService: EnrollmentService,
    protected studentService: StudentService,
    protected programService: ProgramService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ enrollment }) => {
      this.updateForm(enrollment);
    });
    this.studentService
      .query()
      .pipe(
        filter((mayBeOk: HttpResponse<IStudent[]>) => mayBeOk.ok),
        map((response: HttpResponse<IStudent[]>) => response.body)
      )
      .subscribe((res: IStudent[]) => (this.students = res), (res: HttpErrorResponse) => this.onError(res.message));
    this.programService
      .query()
      .pipe(
        filter((mayBeOk: HttpResponse<IProgram[]>) => mayBeOk.ok),
        map((response: HttpResponse<IProgram[]>) => response.body)
      )
      .subscribe((res: IProgram[]) => (this.programs = res), (res: HttpErrorResponse) => this.onError(res.message));
  }

  updateForm(enrollment: IEnrollment) {
    this.editForm.patchValue({
      id: enrollment.id,
      year: enrollment.year,
      period: enrollment.period,
      level: enrollment.level,
      dateEnrollment: enrollment.dateEnrollment,
      student: enrollment.student,
      program: enrollment.program
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    const enrollment = this.createFromForm();
    if (enrollment.id !== undefined) {
      this.subscribeToSaveResponse(this.enrollmentService.update(enrollment.id, enrollment));
    } else {
      this.subscribeToSaveResponse(this.enrollmentService.create(enrollment));
    }
  }

  private createFromForm(): IEnrollment {
    return {
      ...new Enrollment(),
      id: this.editForm.get(['id']).value,
      year: this.editForm.get(['year']).value,
      period: this.editForm.get(['period']).value,
      level: this.editForm.get(['level']).value,
      dateEnrollment: this.editForm.get(['dateEnrollment']).value,
      student: this.editForm.get(['student']).value,
      program: this.editForm.get(['program']).value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IEnrollment>>) {
    result.subscribe(() => this.onSaveSuccess(), () => this.onSaveError());
  }

  protected onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError() {
    this.isSaving = false;
  }
  protected onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }

  trackStudentById(index: number, item: IStudent) {
    return item.id;
  }

  trackProgramById(index: number, item: IProgram) {
    return item.id;
  }
}
