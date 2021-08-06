package com.project.sellerapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sellerapp.dto.InsuranceCompanyDTO;
import com.project.sellerapp.helpers.InsuranceCompanyMapper;
import com.project.sellerapp.model.InsuranceCompany;
import com.project.sellerapp.repository.InsuranceCompanyRepository;

@Service
public class InsuranceCompanyService {

	@Autowired
	private InsuranceCompanyRepository repository;

	public List<InsuranceCompanyDTO> findAll() {
		List<InsuranceCompany> result = repository.findByActive(true);
		return toDTOList(result);
	}
	
	public List<InsuranceCompanyDTO> toDTOList(List<InsuranceCompany> list){
		List<InsuranceCompanyDTO> retVal = new ArrayList<InsuranceCompanyDTO>();
		for(InsuranceCompany entity: list) {
			InsuranceCompanyDTO dto = InsuranceCompanyMapper.toDto(entity);
			retVal.add(dto);
		}
		
		return retVal;
	}
}
