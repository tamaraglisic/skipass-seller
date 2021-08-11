import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Policy } from 'src/app/core/model/Policy';
import { PolicyService } from 'src/app/core/services/policy/policy.service';

@Component({
  selector: 'app-policies-view',
  templateUrl: './policies-view.component.html',
  styleUrls: ['./policies-view.component.scss']
})
export class PoliciesViewComponent implements OnInit {

  policies!: Policy[];

  constructor(
    private policyService: PolicyService,

  ) { }

  ngOnInit(): void {
    this.policyService.getAll().subscribe(
      res=>{
        this.policies = res.body as Policy[];
      }
    )
  }

  choosePolicy(id:any): void{

  }



}
