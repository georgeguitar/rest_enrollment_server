import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { EnrollmentSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective } from './';

@NgModule({
  imports: [EnrollmentSharedCommonModule],
  declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
  entryComponents: [JhiLoginModalComponent],
  exports: [EnrollmentSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EnrollmentSharedModule {
  static forRoot() {
    return {
      ngModule: EnrollmentSharedModule
    };
  }
}
