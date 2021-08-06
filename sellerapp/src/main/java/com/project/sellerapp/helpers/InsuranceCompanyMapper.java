package com.project.sellerapp.helpers;

import com.project.sellerapp.dto.InsuranceCompanyDTO;
import com.project.sellerapp.model.InsuranceCompany;

public class InsuranceCompanyMapper {
	
	public static InsuranceCompanyDTO toDto(InsuranceCompany entity) {
		return new InsuranceCompanyDTO(entity.getId(), entity.getName(), entity.getDescription(), entity.isActive());
	}
	
	public static InsuranceCompany toEntity(InsuranceCompanyDTO dto) {
		return  new InsuranceCompany(dto.getId(), dto.getName(), dto.getDescription(), dto.isActive());
	}

}
