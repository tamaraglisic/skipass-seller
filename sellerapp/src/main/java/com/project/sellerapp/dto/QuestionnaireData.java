package com.project.sellerapp.dto;

import java.util.ArrayList;

import com.project.sellerapp.model.InsuranceCompany;

public class QuestionnaireData {

	private ArrayList<InsuranceCompanyDTO> companyPreferences;
	private String budget; // LOW, MEDIUM, HIGH
	private String equipment; // SKIS, SKIBOARD, SNOWBOARD
	private boolean extraEquipment;
	private int rateSkiingSkills; // 1-5
	private int skiingSpeed; // 1-3
	private int skiSlope; // 1- 5
	private ArrayList<String> protectiveEquipment;
	private boolean hadInjury;
	private ArrayList<String> injuries;
	private ArrayList<String> health;
	
	
	public QuestionnaireData(ArrayList<InsuranceCompanyDTO> companyPreferences, String budget, String equipment,
			boolean extraEquipment, int rateSkiingSkills, int skiingSpeed, int skiSlope,
			ArrayList<String> protectiveEquipment, boolean hadInjury, ArrayList<String> injuries,
			ArrayList<String> health) {
		super();
		this.companyPreferences = companyPreferences;
		this.budget = budget;
		this.equipment = equipment;
		this.extraEquipment = extraEquipment;
		this.rateSkiingSkills = rateSkiingSkills;
		this.skiingSpeed = skiingSpeed;
		this.skiSlope = skiSlope;
		this.protectiveEquipment = protectiveEquipment;
		this.hadInjury = hadInjury;
		this.injuries = injuries;
		this.health = health;
	}


	public QuestionnaireData() {
		super();
	}


	public ArrayList<InsuranceCompanyDTO> getCompanyPreferences() {
		return companyPreferences;
	}


	public void setCompanyPreferences(ArrayList<InsuranceCompanyDTO> companyPreferences) {
		this.companyPreferences = companyPreferences;
	}


	public String getBudget() {
		return budget;
	}


	public void setBudget(String budget) {
		this.budget = budget;
	}


	public String getEquipment() {
		return equipment;
	}


	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}


	public boolean isExtraEquipment() {
		return extraEquipment;
	}


	public void setExtraEquipment(boolean extraEquipment) {
		this.extraEquipment = extraEquipment;
	}


	public int getRateSkiingSkills() {
		return rateSkiingSkills;
	}


	public void setRateSkiingSkills(int rateSkiingSkills) {
		this.rateSkiingSkills = rateSkiingSkills;
	}


	public int getSkiingSpeed() {
		return skiingSpeed;
	}


	public void setSkiingSpeed(int skiingSpeed) {
		this.skiingSpeed = skiingSpeed;
	}


	public int getSkiSlope() {
		return skiSlope;
	}


	public void setSkiSlope(int skiSlope) {
		this.skiSlope = skiSlope;
	}


	public ArrayList<String> getProtectiveEquipment() {
		return protectiveEquipment;
	}


	public void sets(ArrayList<String> protectiveEquipment) {
		this.protectiveEquipment = protectiveEquipment;
	}


	public boolean isHadInjury() {
		return hadInjury;
	}


	public void setHadInjury(boolean hadInjury) {
		this.hadInjury = hadInjury;
	}


	public ArrayList<String> getInjuries() {
		return injuries;
	}


	public void setInjuries(ArrayList<String> injuries) {
		this.injuries = injuries;
	}


	public ArrayList<String> getHealth() {
		return health;
	}


	public void setHealth(ArrayList<String> health) {
		this.health = health;
	}

	
}
