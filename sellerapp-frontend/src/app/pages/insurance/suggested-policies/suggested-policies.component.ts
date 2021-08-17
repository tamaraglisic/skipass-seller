import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Policy } from 'src/app/core/model/Policy';
import { PolicyService } from 'src/app/core/services/policy/policy.service';

@Component({
  selector: 'app-suggested-policies',
  templateUrl: './suggested-policies.component.html',
  styleUrls: ['./suggested-policies.component.scss']
})
export class SuggestedPoliciesComponent implements OnInit {

  ticketsId!: any;
  @Input() policies!: Policy[];

  constructor(
    private policyService: PolicyService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.ticketsId = this.route.snapshot.params.id;
  }

  choosePolicy(id:any): void{
    
  }
}
