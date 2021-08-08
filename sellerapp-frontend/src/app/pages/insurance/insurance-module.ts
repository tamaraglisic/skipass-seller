import { NgModule } from '@angular/core';
import { MaterialModule } from '../material-module';
import { PolicyComponent } from './policy/policy.component';
import { QuestionnaireComponent } from './questionnaire/questionnaire.component';


@NgModule({
  declarations: [ QuestionnaireComponent, PolicyComponent],
  imports: [ MaterialModule ],
  exports: [ QuestionnaireComponent, PolicyComponent ],
  providers: []
})

export class InsuranceModule { }