import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { InsuranceCompany } from 'src/app/core/model/InsuranceCompany';
import { Policy } from 'src/app/core/model/Policy';
import { QuestionnaireData } from 'src/app/core/model/QuestionnaireData';
import { DataService } from 'src/app/core/services/data-service/data.service';
import { InsuranceService } from 'src/app/core/services/insurance/insurance.service';
import { PolicyService } from 'src/app/core/services/policy/policy.service';

@Component({
  selector: 'app-questionnaire',
  templateUrl: './questionnaire.component.html',
  styleUrls: ['./questionnaire.component.scss']
})
export class QuestionnaireComponent implements OnInit {

  ticketsId!: any;
  insuranceForm!: FormGroup;
  questionnaireData!: QuestionnaireData;
  companies!: InsuranceCompany[];
  selectedCompanies!: InsuranceCompany[];
  selectedEquipments!: any;
  protectiveEquipments: any[] = ['Helmet','Palm protection', 'Knee protection', 'Buttock protection', 'Back protection', 'Protective jacket'];
  injuries: any[] = ['Fracture','Dislocation', 'Neck/spine injury', 'Head injury', 'Other'];
  selectedInjuries!: any;
  healthOptions: any[] = ['Fracture','Dislocation', 'Neck/spine injury', 'Head injury','Spine deformity', 'Orthopaedic surgery', 'Hook or knee replacement'];
  selectedHealth!: any;
  suggestedPolicies!: Policy[];

  constructor(
    private fb: FormBuilder,
    private insuranceService: InsuranceService,
    private policyService: PolicyService,
    private route: ActivatedRoute,
    private router: Router,
    private dataService: DataService,
  ) { }

  ngOnInit(): void {
    this.ticketsId = this.route.snapshot.params.id;
    console.log(this.ticketsId)
    this.createForm();
    this.insuranceService.getAll().subscribe(
      res => {
        this.companies = res.body as InsuranceCompany[];
       
      });
  }

  createForm(): void {
    this.insuranceForm = this.fb.group({
      budget: [''],
      equipment: [''],
      rateSkiingSkills: [],
      skiingSpeed: [],
      skiSlope: [],
      hadInjury: [],
      extraEquipment: [],
  
    });
  }

  sendQuestionnaire(): void {
    this.questionnaireData = this.insuranceForm.value;
    this.questionnaireData.companyPreferences = this.selectedCompanies;
    this.questionnaireData.protectiveEquipment = this.selectedEquipments;
    this.questionnaireData.health = this.selectedHealth;
    this.questionnaireData.injuries = this.selectedInjuries;

    this.policyService.sendQuestionnaire(this.questionnaireData).subscribe(
      res => {
        this.suggestedPolicies = res.body as Policy[];
        console.log(this.suggestedPolicies);
        this.dataService.updateRouteData(this.suggestedPolicies);
        this.router.navigate(['/suggested-policies/'+this.ticketsId])
      }
    )
    
  }

  onSelection(event: any): void{
    console.log(event);
    this.selectedCompanies = event;
  }


  onEquipmentSelection(event: any): void{
    console.log(event);
    this.selectedEquipments = event;
  }

  onInjurySelection(event: any): void{
    console.log(event);
    this.selectedInjuries = event;
  }

  onHealthSelection(event: any): void{
    console.log(event);
    this.selectedHealth = event;
  }
}
