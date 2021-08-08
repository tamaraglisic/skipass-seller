package com.project.sellerapp.helpers;

import com.project.sellerapp.dto.InsuranceCompanyDTO;
import com.project.sellerapp.dto.PolicyDTO;
import com.project.sellerapp.model.InsuranceCompany;
import com.project.sellerapp.model.Policy;

public class PolicyMapper {
	
	public static PolicyDTO toDto(Policy entity)
	{
		InsuranceCompanyDTO company = InsuranceCompanyMapper.toDto(entity.getInsuranceCompany());
		PolicyDTO dto = new PolicyDTO(entity.getId(), company, entity.getPrice(),
				entity.isMedicalAssistance(), entity.isInpatientTreatment(), 
				entity.isMedication(), entity.isMedicalSupplies(), entity.isOrthopaedicAids(), 
				entity.isTransportToHospital(), entity.isHospitalTreatment(), 
				entity.isDiagnostics(), entity.isUrgentOperations(), entity.isAccidentalDeath(),
				entity.isAccidentalPermanentDisability(), entity.isRescueExpenses(), entity.isSkiEquipment(),
				entity.isExtraEquipment(), entity.isVip());
		return dto;
	}
	
	public static Policy toEntity(PolicyDTO dto)
	{
		InsuranceCompany company = InsuranceCompanyMapper.toEntity(dto.getInsuranceCompany());

		Policy entity = new Policy(dto.getId(), company, dto.getPrice(),
				dto.isMedicalAssistance(), dto.isInpatientTreatment(), 
				dto.isMedication(), dto.isMedicalSupplies(), dto.isOrthopaedicAids(), 
				dto.isTransportToHospital(), dto.isHospitalTreatment(), 
				dto.isDiagnostics(), dto.isUrgentOperations(), dto.isAccidentalDeath(),
				dto.isAccidentalPermanentDisability(), dto.isRescueExpenses(), dto.isSkiEquipment(),
				dto.isExtraEquipment(), dto.isVip());
		//to do
		return entity;
	}

}
