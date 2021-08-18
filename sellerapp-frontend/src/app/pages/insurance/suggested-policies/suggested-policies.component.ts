import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Observable } from 'rxjs';
import { Policy } from 'src/app/core/model/Policy';
import { PurchasedPolicy } from 'src/app/core/model/PurchasedPolicy';
import { DataService } from 'src/app/core/services/data-service/data.service';
import { PolicyService } from 'src/app/core/services/policy/policy.service';
import { PurchasedPolicyService } from 'src/app/core/services/purchased-policy/purchased-policy';

@Component({
  selector: 'app-suggested-policies',
  templateUrl: './suggested-policies.component.html',
  styleUrls: ['./suggested-policies.component.scss']
})
export class SuggestedPoliciesComponent implements OnInit {

  ticketsId!: any;
  policies!: Policy[];

  constructor(
    private purchasedPolicyService: PurchasedPolicyService,
    private route: ActivatedRoute,
    private dataService: DataService,
    private toastr: ToastrService,
  ) { }

  ngOnInit(): void {
    this.ticketsId = this.route.snapshot.params.id;
    this.policies = this.dataService.routeData().slice(0,5);
  }

  choosePolicy(choosed:any): void{
    const purchasedPolicy: PurchasedPolicy = {policy: choosed, tickets : {id: this.ticketsId}};
    this.purchasedPolicyService.addNew(purchasedPolicy).subscribe(
      res=>{
        this.toastr.success("Succesfully purchased!");
      }
    )
  }
}
