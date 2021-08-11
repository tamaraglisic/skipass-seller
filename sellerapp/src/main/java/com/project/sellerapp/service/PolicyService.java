package com.project.sellerapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sellerapp.dto.PolicyDTO;
import com.project.sellerapp.dto.SkiResortDTO;
import com.project.sellerapp.helpers.PolicyMapper;
import com.project.sellerapp.helpers.SkiResortMapper;
import com.project.sellerapp.model.Policy;
import com.project.sellerapp.model.SkiResort;
import com.project.sellerapp.repository.PolicyRepository;

@Service
public class PolicyService {

	@Autowired
	private PolicyRepository repository;

	public List<PolicyDTO> findAll() {
		List<Policy> policies = repository.findAll();
		if(policies != null) {
			return toDTOList(policies);
		}
		return null;
	}
	
	
	private List<PolicyDTO> toDTOList(List<Policy> list){
		List<PolicyDTO> retVal = new ArrayList<PolicyDTO>();
		for(Policy entity: list) {
			PolicyDTO dto = PolicyMapper.toDto(entity);
			retVal.add(dto);
		}
		return retVal;
	}
}
