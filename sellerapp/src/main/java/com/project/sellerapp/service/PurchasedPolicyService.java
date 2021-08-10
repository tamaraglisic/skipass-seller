package com.project.sellerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sellerapp.dto.PurchasedPolicyDTO;
import com.project.sellerapp.helpers.PurchasedPolicyMapper;
import com.project.sellerapp.model.PurchasedPolicy;
import com.project.sellerapp.repository.PurchasedPolicyRepository;

@Service
public class PurchasedPolicyService {

	@Autowired
	private PurchasedPolicyRepository repository;

	public PurchasedPolicyDTO findById(Long id) {

		PurchasedPolicy result = repository.findById(id).orElse(null);
		if(result!=null) {
			return PurchasedPolicyMapper.toDto(result);
		}
		return null;
	}

	public void usePolicy(String desc, Long id) {
		PurchasedPolicy result = repository.findById(id).orElse(null);
		if(result!=null) {
			result.setUsed(true);
			result.setDescription(desc);
			repository.save(result);
		}
		
	}
	
	public void delete(Long id) {
		PurchasedPolicy result = repository.findById(id).orElse(null);
		if (result!= null) {
			repository.deleteById(id);
		}
	}
}
