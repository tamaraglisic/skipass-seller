package com.project.sellerapp.helpers;

import java.util.ArrayList;
import java.util.List;

import com.project.sellerapp.dto.PolicyDTO;
import com.project.sellerapp.dto.PurchasedPolicyDTO;
import com.project.sellerapp.dto.TicketsDTO;
import com.project.sellerapp.model.Policy;
import com.project.sellerapp.model.PurchasedPolicy;
import com.project.sellerapp.model.Tickets;

public class PurchasedPolicyMapper {

	
	public static PurchasedPolicyDTO toDto(PurchasedPolicy entity)
	{
		PolicyDTO policy = PolicyMapper.toDto(entity.getPolicy());
		//TicketsDTO tickets = new TicketsDTO(entity.getTickets().getId(), SkiResortMapper.toDto(entity.getTickets().getSkiResort()));
		PurchasedPolicyDTO dto = new PurchasedPolicyDTO(entity.getId(), policy,
				null, entity.isUsed(), entity.getDescription(), entity.getUsingStart(), entity.getUsingEnd());
	
		//dto.setTickets(tickets);
		return dto;
	}
	
	public static PurchasedPolicy toEntity(PurchasedPolicyDTO dto)
	{

		Policy policy = PolicyMapper.toEntity(dto.getPolicy());
		//Tickets tickets = TicketsMapper.toEntity(dto.getTickets());
		//Tickets tickets = new Tickets(dto.getTickets().getId());
		PurchasedPolicy entity = new PurchasedPolicy(dto.getId(), policy,
				null, dto.isUsed(), dto.getDescription(), 
				dto.getUsingStart(), dto.getUsingEnd());
		//entity.setTickets(tickets);
		return entity;
	}
	
	public static List<PurchasedPolicyDTO> toDtoList(List<PurchasedPolicy> entities){
		List<PurchasedPolicyDTO> retVal = new ArrayList<PurchasedPolicyDTO>();
		for(PurchasedPolicy entity: entities) {
			retVal.add(toDto(entity));
		}
		return retVal;
	}
	
	public static List<PurchasedPolicy> toEntityList(List<PurchasedPolicyDTO> dtos){
		List<PurchasedPolicy> retVal = new ArrayList<PurchasedPolicy>();
		for(PurchasedPolicyDTO dto: dtos) {
			retVal.add(toEntity(dto));
		}
		return retVal;
	}
}
