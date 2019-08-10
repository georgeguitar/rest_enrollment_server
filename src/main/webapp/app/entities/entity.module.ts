import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'student',
        loadChildren: './student/student.module#EnrollmentStudentModule'
      },
      {
        path: 'enrollment',
        loadChildren: './enrollment/enrollment.module#EnrollmentEnrollmentModule'
      },
      {
        path: 'program',
        loadChildren: './program/program.module#EnrollmentProgramModule'
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ],
  declarations: [],
  entryComponents: [],
  providers: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EnrollmentEntityModule {}
