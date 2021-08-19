import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Observable } from 'rxjs';
import { Policy } from 'src/app/core/model/Policy';
import { PurchasedPolicy } from 'src/app/core/model/PurchasedPolicy';
import { Tickets } from 'src/app/core/model/Tickets';
import { DataService } from 'src/app/core/services/data-service/data.service';
import { PolicyService } from 'src/app/core/services/policy/policy.service';
import { PurchasedPolicyService } from 'src/app/core/services/purchased-policy/purchased-policy';
import { TicketsService } from 'src/app/core/services/tickets/tickets.service';
import { ConfirmationComponent, ConfirmDialogModel } from '../../shared/confirmation/confirmation.component';

@Component({
  selector: 'app-suggested-policies',
  templateUrl: './suggested-policies.component.html',
  styleUrls: ['./suggested-policies.component.scss']
})
export class SuggestedPoliciesComponent implements OnInit {

  ticketsId!: any;
  tickets!: Tickets ;
  numOfUsers: number = 0;
  policies!: Policy[];
  result!: any;

  constructor(
    private purchasedPolicyService: PurchasedPolicyService,
    private ticketsService: TicketsService,
    private route: ActivatedRoute,
    private dataService: DataService,
    private toastr: ToastrService,
    public dialog: MatDialog,

  ) { }

  ngOnInit(): void {
    this.ticketsId = this.route.snapshot.params.id;
    this.policies = this.dataService.routeData().slice(0,5);

    this.ticketsService.getOne(this.ticketsId).subscribe(
      res=>{
        this.tickets = res.body as Tickets;
      }
    );

    this.ticketsService.getNumOfUsers(this.ticketsId).subscribe(
      res=>{
        this.numOfUsers = res.body as number;
      }
    )
  }

  choosePolicy(choosed:any): void{
    let numOfPurchased = this.tickets.purchasedPolicies? this.tickets.purchasedPolicies.length : 0;
    let remainPolicies = this.numOfUsers - numOfPurchased;
    const purchasedPolicy: PurchasedPolicy = {policy: choosed, tickets : {id: this.ticketsId}};

    if(remainPolicies > 1){
      // open dialog
      const message = `Do you want to purchase same policy for the rest of the users?`
      const dialogData = new ConfirmDialogModel('Confirm Action', message);
      const dialogRef = this.dialog.open(ConfirmationComponent, {
          maxWidth: '400px',
          data: dialogData
      });

      dialogRef.afterClosed().subscribe(dialogResult => {
        this.result = dialogResult;
          if (this.result === true){
            // primeni za ostatak
            for(let i = 0; i < remainPolicies; i++){
              this.purchasedPolicyService.addNew(purchasedPolicy).subscribe(
                res=>{
                  this.toastr.success("Succesfully purchased!");
              });
            }
          }
          else {
            // primeni samo jednom
            this.purchasedPolicyService.addNew(purchasedPolicy).subscribe(
              res=>{
                this.toastr.success("Succesfully purchased!");
            });
          }
        })
    
    }
    
  }
}
