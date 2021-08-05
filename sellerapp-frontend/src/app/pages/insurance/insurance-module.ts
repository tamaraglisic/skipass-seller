import { NgModule } from '@angular/core';
import { MaterialModule } from '../material-module';
import { QuestionnaireComponent } from './questionnaire/questionnaire.component';


@NgModule({
  declarations: [ QuestionnaireComponent ],
  imports: [ MaterialModule ],
  exports: [ QuestionnaireComponent ],
  providers: []
})

export class InsuranceModule { }