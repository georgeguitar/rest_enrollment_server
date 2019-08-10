import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IProgram } from 'app/shared/model/program.model';
import { AccountService } from 'app/core';
import { ProgramService } from './program.service';

@Component({
  selector: 'jhi-program',
  templateUrl: './program.component.html'
})
export class ProgramComponent implements OnInit, OnDestroy {
  programs: IProgram[];
  currentAccount: any;
  eventSubscriber: Subscription;

  constructor(
    protected programService: ProgramService,
    protected jhiAlertService: JhiAlertService,
    protected eventManager: JhiEventManager,
    protected accountService: AccountService
  ) {}

  loadAll() {
    this.programService
      .query()
      .pipe(
        filter((res: HttpResponse<IProgram[]>) => res.ok),
        map((res: HttpResponse<IProgram[]>) => res.body)
      )
      .subscribe(
        (res: IProgram[]) => {
          this.programs = res;
        },
        (res: HttpErrorResponse) => this.onError(res.message)
      );
  }

  ngOnInit() {
    this.loadAll();
    this.accountService.identity().then(account => {
      this.currentAccount = account;
    });
    this.registerChangeInPrograms();
  }

  ngOnDestroy() {
    this.eventManager.destroy(this.eventSubscriber);
  }

  trackId(index: number, item: IProgram) {
    return item.id;
  }

  registerChangeInPrograms() {
    this.eventSubscriber = this.eventManager.subscribe('programListModification', response => this.loadAll());
  }

  protected onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }
}
