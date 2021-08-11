import { Component, Input, OnInit } from '@angular/core';
import { PurchasedPolicy } from 'src/app/core/model/PurchasedPolicy';

@Component({
  selector: 'app-policy-details',
  templateUrl: './policy-details.component.html',
  styleUrls: ['./policy-details.component.scss']
})
export class PolicyDetailsComponent implements OnInit {

  @Input() purchased: any = {policy: {}};
  constructor() { }

  ngOnInit(): void {
  }

}
