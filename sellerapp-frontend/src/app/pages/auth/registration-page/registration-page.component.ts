import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AuthenticationService } from 'src/app/core/services/authentication/authentication.service';

@Component({
  selector: 'app-registration-page',
  templateUrl: './registration-page.component.html',
  styleUrls: ['./registration-page.component.scss']
})
export class RegistrationPageComponent implements OnInit {

  regForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private authService: AuthenticationService,
  ) { }

  ngOnInit(): void {
    this.createForm();
  }

  createForm() : void{
    this.regForm = this.fb.group({
      firstName: [''],
      lastName: [''],
      email:[''],
      password: [''],
      repeatedPass: ['']
    });
  }

  register(): void {
    if(this.regForm.get('password')?.value != this.regForm.get('repeatedPass')?.value){
      return;
    }
    let data = {
      firstName: this.regForm.get('firstName')?.value,
      lastName: this.regForm.get('lastName')?.value,
      email: this.regForm.get('email')?.value,
      password: this.regForm.get('password')?.value,
    }
    this.authService.signUp(data).subscribe(
      res => {
        console.log("Successful")
      }
    )

  }
}
