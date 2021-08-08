import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
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


  constructor(
    private fb: FormBuilder,
    private purchasedPolicyService: PurchasedPolicyService
  ) { }

  ngOnInit(): void {
    this.createSearchForm();
    this.createInputForm();
  }

  createSearchForm():void{
    this.searchForm = this.fb.group({
      inputId: ['']
      });

  }
  createInputForm():void{
    this.inputForm = this.fb.group({
      description: ['']
      });

  }

  search(): void {
    if(this.searchForm.value.inputId != ""){
      this.purchasedPolicyService.getOne(this.searchForm.value.inputId).subscribe(
        res =>{
          this.purchased = res.body as PurchasedPolicy;
        },
        err =>{
          this.purchased = {policy: {}}
        }
      )
    }
  }

  input(): void {

  }
}
