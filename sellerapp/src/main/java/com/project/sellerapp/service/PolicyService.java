package com.project.sellerapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sellerapp.dto.PolicyDTO;
import com.project.sellerapp.dto.QuestionnaireData;
import com.project.sellerapp.helpers.PolicyMapper;
import com.project.sellerapp.model.Policy;
import com.project.sellerapp.repository.PolicyRepository;

@Service
public class PolicyService {

	@Autowired
	private PolicyRepository repository;
	
	@Autowired
	private KieService kieService;
	
	public List<PolicyDTO> proceedQuestionnaire(QuestionnaireData questionnaireData) {
		List<PolicyDTO> retVal = new ArrayList<PolicyDTO>();
		List<PolicyDTO> allPolicies = findAll();

		kieService.getInsuranceRuleSession().getAgenda().getAgendaGroup("ranking").setFocus();
		for(PolicyDTO p: allPolicies) {
			kieService.getInsuranceRuleSession().insert(p);
		}
		kieService.getInsuranceRuleSession().insert(questionnaireData);
		kieService.getInsuranceRuleSession().fireAllRules();
		kieService.disposeInsuranceRuleSession();
		
		for(PolicyDTO p: allPolicies) {
			System.out.println(p.getPrice() + " points: " + p.getPoints());
		}
		return allPolicies;
	}

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
