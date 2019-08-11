import { Component, OnInit } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { IProgram, Program } from 'app/shared/model/program.model';
import { ProgramService } from './program.service';

@Component({
  selector: 'jhi-program-update',
  templateUrl: './program-update.component.html'
})
export class ProgramUpdateComponent implements OnInit {
  isSaving: boolean;

  editForm = this.fb.group({
    id: [],
    name: [null, [Validators.required, Validators.minLength(1), Validators.maxLength(60)]],
    semesters: [null, [Validators.required]],
    title: [null, [Validators.required, Validators.minLength(1), Validators.maxLength(60)]],
    credits: [null, [Validators.required]]
  });

  constructor(protected programService: ProgramService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ program }) => {
      this.updateForm(program);
    });
  }

  updateForm(program: IProgram) {
    this.editForm.patchValue({
      id: program.id,
      name: program.name,
      semesters: program.semesters,
      title: program.title,
      credits: program.credits
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    const program = this.createFromForm();
    if (program.id !== undefined) {
      this.subscribeToSaveResponse(this.programService.update(program.id, program));
    } else {
      this.subscribeToSaveResponse(this.programService.create(program));
    }
  }

  private createFromForm(): IProgram {
    return {
      ...new Program(),
      id: this.editForm.get(['id']).value,
      name: this.editForm.get(['name']).value,
      semesters: this.editForm.get(['semesters']).value,
      title: this.editForm.get(['title']).value,
      credits: this.editForm.get(['credits']).value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IProgram>>) {
    result.subscribe(() => this.onSaveSuccess(), () => this.onSaveError());
  }

  protected onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError() {
    this.isSaving = false;
  }
}
