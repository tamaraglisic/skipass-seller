import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Policy } from 'src/app/core/model/Policy';
import { PurchasedPolicy } from 'src/app/core/model/PurchasedPolicy';
import { Tickets } from 'src/app/core/model/Tickets';
import { PolicyService } from 'src/app/core/services/policy/policy.service';
import { PurchasedPolicyService } from 'src/app/core/services/purchased-policy/purchased-policy';
import { TicketsService } from 'src/app/core/services/tickets/tickets.service';
import { ConfirmationComponent, ConfirmDialogModel } from '../../shared/confirmation/confirmation.component';

@Component({
  selector: 'app-policies-view',
  templateUrl: './policies-view.component.html',
  styleUrls: ['./policies-view.component.scss']
})
export class PoliciesViewComponent implements OnInit {

  policies: PurchasedPolicy[]=[];
  ticketsId!: any;
  result: any;
  numOfUsers!: number;
  tickets!: Tickets;
  disableButton: boolean = false;

  constructor(
    private policyService: PolicyService,
    private purchasedPolicyService: PurchasedPolicyService,
    private ticketsService: TicketsService,
    private route: ActivatedRoute,
    public dialog: MatDialog,
    private toastr: ToastrService,
    private router: Router,

  ) { }

  ngOnInit(): void {
    this.ticketsId = this.route.snapshot.params.id;
    this.purchasedPolicyService.getPoliciesForTickets(this.ticketsId).subscribe(
      res=>{
        this.policies = res.body as PurchasedPolicy[];
        this.ticketsService.getNumOfUsers(this.ticketsId).subscribe(
          res=>{
            this.numOfUsers = res.body as number;
            this.disableButton = this.numOfUsers <= this.policies.length;
          }
        );
      }
    );
    
  }

  buyNewInsurance(): void{
    this.router.navigate(['/insurance-questionnaire/'+this.ticketsId]);
  }
  removePolicy(id:any): void{
    console.log(id);
    const dialogData = new ConfirmDialogModel('Remove Insurance', 'Are you sure?');
    const dialogRef = this.dialog.open(ConfirmationComponent, {
      maxWidth: '400px',
      data: dialogData
      });

    dialogRef.afterClosed().subscribe(dialogResult => {
    this.result = dialogResult;
    if (this.result === true){
        console.log("Confirm");
      // izbrisi purchased policy
        this.purchasedPolicyService.delete(id).subscribe(
          res =>{
          this.toastr.success('Insurance removed');
          window.location.reload();
          })
      }
    })
  }

  compareDates(startDate: any): boolean{
    let currentDate = new Date();

   return startDate-currentDate.getTime() > 172800000;
  }


}
