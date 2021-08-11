import { NgModule } from '@angular/core';
import { MaterialModule } from '../material-module';
import { PoliciesViewComponent } from './policies-view/policies-view.component';
import { PolicyDetailsComponent } from './policy-details/policy-details.component';
import { PolicyComponent } from './policy/policy.component';
import { QuestionnaireComponent } from './questionnaire/questionnaire.component';


@NgModule({
  declarations: [ QuestionnaireComponent, PolicyComponent, PoliciesViewComponent, PolicyDetailsComponent],
  imports: [ MaterialModule ],
  exports: [ QuestionnaireComponent, PolicyComponent, PoliciesViewComponent, PolicyDetailsComponent ],
  providers: []
})

export class InsuranceModule { }