package com.project.sellerapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Policy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "insurance_company_id", nullable = true)
	private InsuranceCompany insuranceCompany;
	
	@Column(unique = false, nullable = false)
	private double price;

	@Column(unique = false, nullable = false)
	private boolean medicalAssistance;
	
	@Column(unique = false, nullable = false)
	private boolean inpatientTreatment;
	
	@Column(unique = false, nullable = false)
	private boolean medication;
	
	@Column(unique = false, nullable = false)
	private boolean medicalSupplies;
	
	@Column(unique = false, nullable = false)
	private boolean orthopaedicAids;
	
	@Column(unique = false, nullable = false)
	private boolean transportToHospital;
	
	@Column(unique = false, nullable = false)
	private boolean hospitalTreatment;
	
	@Column(unique = false, nullable = false)
	private boolean diagnostics;
	
	@Column(unique = false, nullable = false)
	private boolean urgentOperations;
	
	@Column(unique = false, nullable = false)
	private boolean accidentalDeath;
	
	@Column(unique = false, nullable = false)
	private boolean accidentalPermanentDisability;
	
	@Column(unique = false, nullable = false)
	private boolean rescueExpenses;
	
	@Column(unique = false, nullable = false)
	private boolean skiEquipement;
	
	@Column(unique = false, nullable = false)
	private boolean extraEquipement;

	public Policy(Long id, InsuranceCompany insuranceCompany, double price, boolean medicalAssistance,
			boolean inpatientTreatment, boolean medication, boolean medicalSupplies, boolean orthopaedicAids,
			boolean transportToHospital, boolean hospitalTreatment, boolean diagnostics, boolean urgentOperations,
			boolean accidentalDeath, boolean accidentalPermanentDisability, boolean rescueExpenses,
			boolean skiEquipement, boolean extraEquipement) {
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
		this.skiEquipement = skiEquipement;
		this.extraEquipement = extraEquipement;
	}

	public Policy() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public InsuranceCompany getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
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

	public boolean isSkiEquipement() {
		return skiEquipement;
	}

	public void setSkiEquipement(boolean skiEquipement) {
		this.skiEquipement = skiEquipement;
	}

	public boolean isExtraEquipement() {
		return extraEquipement;
	}

	public void setExtraEquipement(boolean extraEquipement) {
		this.extraEquipement = extraEquipement;
	}
	
	
}
