import { InsuranceCompany } from "./InsuranceCompany";

export interface Policy {
    id?: number;
	insuranceCompany?: InsuranceCompany;
	price?: number;
	medicalAssistance?: boolean;
	inpatientTreatment?: boolean;
	medication?: boolean;
	medicalSupplies?: boolean;
	orthopaedicAids?: boolean;
	transportToHospital?: boolean;
	hospitalTreatment?: boolean;
	diagnostics?: boolean;
	urgentOperations?: boolean;
	accidentalDeath?: boolean;
	accidentalPermanentDisability?: boolean;
	rescueExpenses?: boolean;
	skiEquipment?: boolean;
	extraEquipement?: boolean;
	vip?: boolean;
}