package com.project.sellerapp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.project.sellerapp.dto.PolicyDTO;
import com.project.sellerapp.dto.PurchasedPolicyDTO;
import com.project.sellerapp.dto.QuestionnaireData;
import com.project.sellerapp.dto.RegisteredUserDTO;
import com.project.sellerapp.dto.TicketsDTO;
import com.project.sellerapp.helpers.PolicyMapper;
import com.project.sellerapp.helpers.PolicySorter;
import com.project.sellerapp.helpers.TicketsMapper;
import com.project.sellerapp.model.Policy;
import com.project.sellerapp.model.RegisteredUser;
import com.project.sellerapp.model.Tickets;
import com.project.sellerapp.model.User;
import com.project.sellerapp.repository.PolicyRepository;

@Service
public class PolicyService {

	@Autowired
	private PolicyRepository repository;
	@Autowired
	private RegisteredUserService registeredUserService;
	@Autowired
	private PurchasedPolicyService purchasedPolicyService;
		
	@Autowired
	private KieService kieService;
	
	public List<PolicyDTO> proceedQuestionnaire(QuestionnaireData questionnaireData) {
		
		RegisteredUser registeredUser;
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String username = ((User) currentUser.getPrincipal()).getEmail();
        registeredUser = registeredUserService.findByEmail(username);
        RegisteredUserDTO regDto = new RegisteredUserDTO();
        regDto.setTickets(toDtoSet(registeredUser.getTickets()));
        
        List<PurchasedPolicyDTO> res = new ArrayList<PurchasedPolicyDTO>();
        List<PurchasedPolicyDTO> purchased = new ArrayList<PurchasedPolicyDTO>();

		List<PolicyDTO> allPolicies = findAll();

		kieService.getInsuranceRuleSession().getAgenda().getAgendaGroup("ranking").setFocus();
		
		for(PolicyDTO p: allPolicies) {
			kieService.getInsuranceRuleSession().insert(p);
		}
		
		for(TicketsDTO tickets: regDto.getTickets()) {
        	res = purchasedPolicyService.findByTicketsId(tickets.getId());
        	for(PurchasedPolicyDTO pDTO: res) {
        		purchased.add(pDTO);
        	}
        }
		kieService.getInsuranceRuleSession().insert(purchased);
		kieService.getInsuranceRuleSession().insert(questionnaireData);
		kieService.getInsuranceRuleSession().fireAllRules();
		kieService.disposeInsuranceRuleSession();
		
		Collections.sort(allPolicies, new PolicySorter().reversed());
		
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
	
	private Set<TicketsDTO> toDtoSet(Set<Tickets> list){
		Set<TicketsDTO> retVal = new HashSet<TicketsDTO>();
		for(Tickets t: list) {
			TicketsDTO dto = TicketsMapper.toDto(t);
			retVal.add(dto);
		}
		return retVal;
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
