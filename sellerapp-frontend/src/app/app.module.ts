import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing/app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Interceptor } from './interceptors/intercept.service';
import { MaterialModule } from './pages/material-module';
import { NavbarAdminComponent } from './navbar/navbar-admin/navbar-admin.component';
import { NavbarRegisteredUserComponent } from './navbar/navbar-registered-user/navbar-registered-user.component';
import { NavbarInstructorComponent } from './navbar/navbar-instructor/navbar-instructor.component';
import { ResortModule } from './pages/resort/resort-module';
import { ReservationsModule } from './pages/reservations/reservations-module';
import { ChartsModule } from 'ng2-charts';
import { SharedModule } from './pages/shared/shared-module';
import { ToastrModule } from 'ngx-toastr';
import { NavbarNonAuthComponent } from './navbar/navbar-non-auth/navbar-non-auth.component';
import { InsuranceModule } from './pages/insurance/insurance-module';
import { AuthModule } from './pages/auth/auth.module';
import { ErrorModule } from './pages/error/error-module';

@NgModule({
  declarations: [
    AppComponent,
    NavbarAdminComponent,
    NavbarRegisteredUserComponent,
    NavbarInstructorComponent,
    NavbarNonAuthComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    //AuthModule,
    ChartsModule,
    ResortModule,
    ReservationsModule,
    MaterialModule,
    InsuranceModule,
    ErrorModule,
    HttpClientModule,
    SharedModule,
    ToastrModule.forRoot()
  ],
  providers: [ {provide: HTTP_INTERCEPTORS, useClass: Interceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
