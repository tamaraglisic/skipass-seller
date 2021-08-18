package com.project.sellerapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sellerapp.dto.PurchasedPolicyDTO;
import com.project.sellerapp.helpers.PurchasedPolicyMapper;
import com.project.sellerapp.helpers.Utility;
import com.project.sellerapp.model.Policy;
import com.project.sellerapp.model.PurchasedPolicy;
import com.project.sellerapp.model.Tickets;
import com.project.sellerapp.repository.PolicyRepository;
import com.project.sellerapp.repository.PurchasedPolicyRepository;
import com.project.sellerapp.repository.TicketsRepository;

@Service
public class PurchasedPolicyService {

	@Autowired
	private PurchasedPolicyRepository repository;

	@Autowired
	private PolicyRepository policyRepository;
	
	@Autowired
	private TicketsRepository ticketsRepository;
	
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
//			result.setPolicy(null);
//			result.setTickets(null);
//			repository.save(result);
			repository.deleteById(id);
		}
	}

	public List<PurchasedPolicyDTO> findByTicketsId(Long id) {
		List<PurchasedPolicy> result = repository.findByTicketsId(id);
		if(result != null) {
			return PurchasedPolicyMapper.toDtoList(result);
		}
		return null;
	}

	public void create(PurchasedPolicyDTO purchased) {
		Policy policy = policyRepository.findById(purchased.getPolicy().getId()).orElse(null);
		Tickets tickets = ticketsRepository.findById(purchased.getTickets().getId()).orElse(null);
		PurchasedPolicy entity = new PurchasedPolicy();
		entity.setPolicy(policy);
		entity.setTickets(tickets);
		entity.setUsingStart(tickets.getUsingStart());
		entity.setUsingEnd(tickets.getUsingEnd());
		entity.setUsed(false);
		int days = (int)Utility.getDays(tickets.getUsingStart(), tickets.getUsingEnd());
		tickets.setBill(tickets.getBill() + (policy.getPrice()/3.0)*days);
		repository.save(entity);
	}
}
