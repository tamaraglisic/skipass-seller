package com.project.sellerapp.helpers;

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
		TicketsDTO tickets = TicketsMapper.toDto(entity.getTickets());
		PurchasedPolicyDTO dto = new PurchasedPolicyDTO(entity.getId(), policy,
				tickets, entity.isUsed(), entity.getDescription(), entity.getUsingStart(), entity.getUsingEnd());
	
		return dto;
	}
	
	public static PurchasedPolicy toEntity(PurchasedPolicyDTO dto)
	{

		Policy policy = PolicyMapper.toEntity(dto.getPolicy());
		Tickets tickets = TicketsMapper.toEntity(dto.getTickets());
		PurchasedPolicy entity = new PurchasedPolicy(dto.getId(), policy,
				tickets, dto.isUsed(), dto.getDescription(), 
				dto.getUsingStart(), dto.getUsingEnd());
		
		return entity;
	}
}
