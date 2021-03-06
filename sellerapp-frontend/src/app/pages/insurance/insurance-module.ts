import { NgModule } from '@angular/core';
import { DataService } from 'src/app/core/services/data-service/data.service';
import { MaterialModule } from '../material-module';
import { PoliciesViewComponent } from './policies-view/policies-view.component';
import { PolicyDetailsComponent } from './policy-details/policy-details.component';
import { PolicyComponent } from './policy/policy.component';
import { QuestionnaireComponent } from './questionnaire/questionnaire.component';
import { SuggestedPoliciesComponent } from './suggested-policies/suggested-policies.component';


@NgModule({
  declarations: [ SuggestedPoliciesComponent, QuestionnaireComponent, PolicyComponent, PoliciesViewComponent, PolicyDetailsComponent],
  imports: [ MaterialModule ],
  exports: [ SuggestedPoliciesComponent, QuestionnaireComponent, PolicyComponent, PoliciesViewComponent, PolicyDetailsComponent ],
  providers: [DataService]
})

export class InsuranceModule { }