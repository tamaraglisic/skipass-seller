import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { PurchasedPolicy } from 'src/app/core/model/PurchasedPolicy';
import { PurchasedPolicyService } from 'src/app/core/services/purchased-policy/purchased-policy';

@Component({
  selector: 'app-policy',
  templateUrl: './policy.component.html',
  styleUrls: ['./policy.component.scss']
})
export class PolicyComponent implements OnInit {

  searchForm!: FormGroup;
  inputForm!: FormGroup;
  purchased: any = {policy: {}};
  descView: boolean = false;
  


  constructor(
    private fb: FormBuilder,
    private purchasedPolicyService: PurchasedPolicyService,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.createSearchForm();
  }

  createSearchForm():void{
    this.searchForm = this.fb.group({
      inputId: ['']
      });

  }
  createInputForm():void{
    this.inputForm = this.fb.group({
      description: [this.purchased.description]
      });

  }

  search(): void {
    if(this.searchForm.value.inputId != ""){
      this.purchasedPolicyService.getOne(this.searchForm.value.inputId).subscribe(
        res =>{
          this.purchased = res.body as PurchasedPolicy;
          this.descView = true;
          this.createInputForm();
        },
        err =>{
          this.purchased = {policy: {}};
          this.descView = false;
        }
      )
    }
  }

  input(): void {
    if(this.inputForm.value.description != ""){
      this.purchasedPolicyService.usePolicy(this.inputForm.value.description, this.purchased.id).subscribe(
        res=>{
          this.toastr.success('Saved!');
        }
      )
    }
  }
}
