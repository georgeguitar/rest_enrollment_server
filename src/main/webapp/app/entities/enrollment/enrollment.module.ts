import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { EnrollmentSharedModule } from 'app/shared';
import {
  EnrollmentComponent,
  EnrollmentDetailComponent,
  EnrollmentUpdateComponent,
  EnrollmentDeletePopupComponent,
  EnrollmentDeleteDialogComponent,
  enrollmentRoute,
  enrollmentPopupRoute
} from './';

const ENTITY_STATES = [...enrollmentRoute, ...enrollmentPopupRoute];

@NgModule({
  imports: [EnrollmentSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    EnrollmentComponent,
    EnrollmentDetailComponent,
    EnrollmentUpdateComponent,
    EnrollmentDeleteDialogComponent,
    EnrollmentDeletePopupComponent
  ],
  entryComponents: [EnrollmentComponent, EnrollmentUpdateComponent, EnrollmentDeleteDialogComponent, EnrollmentDeletePopupComponent],
  providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EnrollmentEnrollmentModule {
  constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
    this.languageHelper.language.subscribe((languageKey: string) => {
      if (languageKey !== undefined) {
        this.languageService.changeLanguage(languageKey);
      }
    });
  }
}
