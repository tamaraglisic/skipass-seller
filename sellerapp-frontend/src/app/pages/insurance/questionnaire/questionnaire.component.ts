import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { InsuranceCompany } from 'src/app/core/model/InsuranceCompany';
import { QuestionnaireData } from 'src/app/core/model/QuestionnaireData';
import { InsuranceService } from 'src/app/core/services/insurance/insurance.service';
import { PolicyService } from 'src/app/core/services/policy/policy.service';

@Component({
  selector: 'app-questionnaire',
  templateUrl: './questionnaire.component.html',
  styleUrls: ['./questionnaire.component.scss']
})
export class QuestionnaireComponent implements OnInit {

  insuranceForm!: FormGroup;
  questionnaireData!: QuestionnaireData;
  companies!: InsuranceCompany[];
  selectedCompanies!: InsuranceCompany[];
  selectedEquipments!: any;
  protectiveEquipments: any[] = ['Helmet','Palm protection', 'Knee protection', 'Buttock protection', 'Back protection', 'Protective jacket'];
  injuries: any[] = ['Fracture','Dislocation', 'Neck/spine injury', 'Head injury', 'Other'];
  selectedInjuries!: any;
  healthOptions: any[] = ['Fracture','Dislocation', 'Neck/spine injury', 'Spine deformity', 'Orthopaedic surgery', 'Hook or knee replacement'];
  selectedHealth!: any;

  constructor(
    private fb: FormBuilder,
    private insuranceService: InsuranceService,
    private policyService: PolicyService
  ) { }

  ngOnInit(): void {
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
        console.log(res);
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
