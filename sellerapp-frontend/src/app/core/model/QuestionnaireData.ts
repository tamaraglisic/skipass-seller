import { InsuranceCompany } from "./InsuranceCompany";

export interface QuestionnaireData {
    companyPreferences?: InsuranceCompany[];
    bugdet?: string;
    equipment?: string;
    extraEquipment?: boolean;
    rateSkiingSkills?: number;
    skiingSpeed?: number;
    skiSlope?:  number;
    protectiveEquipment?: string[];
    hadInjury?: boolean;
    injuries?: string[];
    health?: string[];
}