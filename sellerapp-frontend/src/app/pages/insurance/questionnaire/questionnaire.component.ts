import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { InsuranceCompany } from 'src/app/core/model/InsuranceCompany';

@Component({
  selector: 'app-questionnaire',
  templateUrl: './questionnaire.component.html',
  styleUrls: ['./questionnaire.component.scss']
})
export class QuestionnaireComponent implements OnInit {

  insuranceForm!: FormGroup;
  companies: InsuranceCompany[] = [{id:  1, name: 'UNIQA', description: 'osiguranje'}, {id: 2, name: 'Dunav osiguranje', description: 'osiguranje'}];
  selectedCompanies!: InsuranceCompany[];
  selectedEquipments!: any;
  protectiveEquipments: any[] = ['Helmet','Palm protection', 'Knee protection', 'Buttock protection', 'Back protection', 'Protective jacket'];
  injuries: any[] = ['Fracture','Dislocation', 'Neck/spine injury', 'Head injury', 'Other'];
  selectedInjuries!: any;
  healthOptions: any[] = ['Fracture','Dislocation', 'Neck/spine injury', 'Spine deformity', 'Orthopaedic surgery', 'Hook or knee replacement'];
  selectedHealth!: any;

  constructor(
    private fb: FormBuilder
  ) { }

  ngOnInit(): void {
    this.createForm();
  }

  createForm(): void {
    this.insuranceForm = this.fb.group({
      insuranceBudget: [''],
      equipment: [''],
      skiingSkills: [],
      skiingRides: [],
      skiRuns: [],
      hadInjuries: [],
      extraEquipment: [],
  
    });
  }

  sendQuestionnaire(): void {

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
