import { Routes } from '@angular/router';
import { RoleGuard } from '../guards/role/role.service';
import { LoginGuard } from '../guards/login/login.service';
import { LoginPageComponent } from '../pages/auth/login-page/login-page.component';
import { ResortChooserComponent } from '../pages/resort/resort-chooser/resort-chooser.component';
import { MyReservationsComponent } from '../pages/reservations/my-reservations/my-reservations.component';
import { ResortCapacityComponent } from '../pages/resort/resort-capacity/resort-capacity.component';
import { NewReservationComponent } from '../pages/reservations/new-reservation/new-reservation.component';
import { AllResortsComponent } from '../pages/resort/all-resorts/all-resorts.component';
import { QuestionnaireComponent } from '../pages/insurance/questionnaire/questionnaire.component';
import { PolicyComponent } from '../pages/insurance/policy/policy.component';
import { ErrorUnauthorizedComponent } from '../pages/error/error-unauthorized/error-unauthorized.component';
import { PoliciesViewComponent } from '../pages/insurance/policies-view/policies-view.component';
import { SuggestedPoliciesComponent } from '../pages/insurance/suggested-policies/suggested-policies.component';
import { EditResortComponent } from '../pages/resort/edit-resort/edit-resort.component';
import { NewResortComponent } from '../pages/resort/new-resort/new-resort.component';
import { RegistrationPageComponent } from '../pages/auth/registration-page/registration-page.component';

export const routes :Routes = [
	{
		path: '',
		component: LoginPageComponent
	},
	{
		path: 'login',
		component: LoginPageComponent,
	},
	{
		path: 'registration',
		component: RegistrationPageComponent,
	},
	{
		path: 'error-unauthorized',
		component: ErrorUnauthorizedComponent,
	},
	{
		path: 'ski-resort',
		component: ResortChooserComponent,
		canActivate: [LoginGuard]

	},
	{
		path: 'my-reservations',
		component: MyReservationsComponent,
		canActivate: [LoginGuard]

	},
	{
		path: 'capacity',
		component: ResortCapacityComponent,
	},
	{
		path:'new-reservation',
		component: NewReservationComponent,
		canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_REGISTERED_USER'}
	},
	{
		path:'ski-resorts',
		component: AllResortsComponent,
	},
	{
		path:'home',
		component: ResortChooserComponent,
		//canActivate: [LoginGuard]
	},
	{
		path:'insurance-questionnaire/:id',
		component: QuestionnaireComponent,
		//canActivate: [LoginGuard]
	},
	{
		path: 'policies',
		component: PolicyComponent,
//		data: {expectedRoles: 'ROLE_ADMIN'}

	},
	{
		path: 'all-policies',
		component: PoliciesViewComponent,
//		data: {expectedRoles: 'ROLE_ADMIN'}

	},
	{
		path: 'my-policies/:id',
		component: PoliciesViewComponent,
//		data: {expectedRoles: 'ROLE_REGISTERED_USER'}

	},
	{
		path: 'suggested-policies/:id',
		component: SuggestedPoliciesComponent,
//		data: {expectedRoles: 'ROLE_REGISTERED_USER'}

	},
	{
		path: 'edit-resort/:id',
		component: EditResortComponent,
		data: {expectedRoles: 'ROLE_ADMIN'}

	},
	{
		path: 'new-resort',
		component: NewResortComponent,
		data: {expectedRoles: 'ROLE_ADMIN'}

	}
];
