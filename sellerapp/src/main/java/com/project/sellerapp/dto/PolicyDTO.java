package com.project.sellerapp.dto;

public class PolicyDTO {
	
	private Long id;
	private InsuranceCompanyDTO insuranceCompany;
	private double price;
	private boolean medicalAssistance;
	private boolean inpatientTreatment;
	private boolean medication;
	private boolean medicalSupplies;
	private boolean orthopaedicAids;
	private boolean transportToHospital;
	private boolean hospitalTreatment;
	private boolean diagnostics;
	private boolean urgentOperations;
	private boolean accidentalDeath;
	private boolean accidentalPermanentDisability;
	private boolean rescueExpenses;
	private boolean skiEquipment;
	private boolean extraEquipment;
	private boolean vip;
	private int points;
	
	public PolicyDTO(Long id, InsuranceCompanyDTO insuranceCompany, 
			double price, boolean medicalAssistance,
			boolean inpatientTreatment, boolean medication,
			boolean medicalSupplies, boolean orthopaedicAids,
			boolean transportToHospital, boolean hospitalTreatment,
			boolean diagnostics, boolean urgentOperations,
			boolean accidentalDeath, boolean accidentalPermanentDisability,
			boolean rescueExpenses,
			boolean skiEquipment, boolean extraEquipment, boolean vip) {
		super();
		this.id = id;
		this.insuranceCompany = insuranceCompany;
		this.price = price;
		this.medicalAssistance = medicalAssistance;
		this.inpatientTreatment = inpatientTreatment;
		this.medication = medication;
		this.medicalSupplies = medicalSupplies;
		this.orthopaedicAids = orthopaedicAids;
		this.transportToHospital = transportToHospital;
		this.hospitalTreatment = hospitalTreatment;
		this.diagnostics = diagnostics;
		this.urgentOperations = urgentOperations;
		this.accidentalDeath = accidentalDeath;
		this.accidentalPermanentDisability = accidentalPermanentDisability;
		this.rescueExpenses = rescueExpenses;
		this.skiEquipment = skiEquipment;
		this.extraEquipment = extraEquipment;
		this.vip = vip;
	}

	public PolicyDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public InsuranceCompanyDTO getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(InsuranceCompanyDTO insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isMedicalAssistance() {
		return medicalAssistance;
	}

	public void setMedicalAssistance(boolean medicalAssistance) {
		this.medicalAssistance = medicalAssistance;
	}

	public boolean isInpatientTreatment() {
		return inpatientTreatment;
	}

	public void setInpatientTreatment(boolean inpatientTreatment) {
		this.inpatientTreatment = inpatientTreatment;
	}

	public boolean isMedication() {
		return medication;
	}

	public void setMedication(boolean medication) {
		this.medication = medication;
	}

	public boolean isMedicalSupplies() {
		return medicalSupplies;
	}

	public void setMedicalSupplies(boolean medicalSupplies) {
		this.medicalSupplies = medicalSupplies;
	}

	public boolean isOrthopaedicAids() {
		return orthopaedicAids;
	}

	public void setOrthopaedicAids(boolean orthopaedicAids) {
		this.orthopaedicAids = orthopaedicAids;
	}

	public boolean isTransportToHospital() {
		return transportToHospital;
	}

	public void setTransportToHospital(boolean transportToHospital) {
		this.transportToHospital = transportToHospital;
	}

	public boolean isHospitalTreatment() {
		return hospitalTreatment;
	}

	public void setHospitalTreatment(boolean hospitalTreatment) {
		this.hospitalTreatment = hospitalTreatment;
	}

	public boolean isDiagnostics() {
		return diagnostics;
	}

	public void setDiagnostics(boolean diagnostics) {
		this.diagnostics = diagnostics;
	}

	public boolean isUrgentOperations() {
		return urgentOperations;
	}

	public void setUrgentOperations(boolean urgentOperations) {
		this.urgentOperations = urgentOperations;
	}

	public boolean isAccidentalDeath() {
		return accidentalDeath;
	}

	public void setAccidentalDeath(boolean accidentalDeath) {
		this.accidentalDeath = accidentalDeath;
	}

	public boolean isAccidentalPermanentDisability() {
		return accidentalPermanentDisability;
	}

	public void setAccidentalPermanentDisability(boolean accidentalPermanentDisability) {
		this.accidentalPermanentDisability = accidentalPermanentDisability;
	}

	public boolean isRescueExpenses() {
		return rescueExpenses;
	}

	public void setRescueExpenses(boolean rescueExpenses) {
		this.rescueExpenses = rescueExpenses;
	}

	public boolean isSkiEquipment() {
		return skiEquipment;
	}

	public void setSkiEquipment(boolean skiEquipment) {
		this.skiEquipment = skiEquipment;
	}

	public boolean isExtraEquipment() {
		return extraEquipment;
	}

	public void setExtraEquipment(boolean extraEquipment) {
		this.extraEquipment = extraEquipment;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public void addPoints(int points) {
		this.points += points;
	}
}
