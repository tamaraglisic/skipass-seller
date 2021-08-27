import { NgModule } from '@angular/core';
import { MaterialModule } from '../material-module';
// import { RegisteredUserService } from '../../core/services/registered-user/registered-user.service';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegistrationPageComponent } from './registration-page/registration-page.component';

@NgModule({
  declarations: [LoginPageComponent, RegistrationPageComponent],
  imports: [ MaterialModule],
  exports: [LoginPageComponent, RegistrationPageComponent],
  providers: []
})

export class AuthModule { }