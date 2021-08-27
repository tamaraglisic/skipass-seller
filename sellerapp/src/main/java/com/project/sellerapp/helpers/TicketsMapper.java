package com.project.sellerapp.helpers;

import java.util.HashSet;
import java.util.Set;

import com.project.sellerapp.dto.PurchasedPolicyDTO;
import com.project.sellerapp.dto.TicketUserDTO;
import com.project.sellerapp.dto.TicketsDTO;
import com.project.sellerapp.model.PurchasedPolicy;
import com.project.sellerapp.model.Tickets;
import com.project.sellerapp.model.UserType;

public class TicketsMapper {

	public static TicketsDTO toDto (Tickets entity) {
		Set<TicketUserDTO> users = new HashSet<TicketUserDTO>();
		users.add(new TicketUserDTO(UserType.CHILD, entity.getNumOfChildren(), 0.0));
		users.add(new TicketUserDTO(UserType.ADULT, entity.getNumOfAdult(), 0.0));
		users.add(new TicketUserDTO(UserType.SENIOR, entity.getNumOfSenior(), 0.0));


		Set<PurchasedPolicyDTO> purchasedPolicies = new HashSet<PurchasedPolicyDTO>();
		if(entity.getPurchasedPolicies() != null) {
			for(PurchasedPolicy p: entity.getPurchasedPolicies()) {
				purchasedPolicies.add(PurchasedPolicyMapper.toDto(p));
			}
		}
		
		return new TicketsDTO(entity.getId(), SkiResortMapper.toDto(entity.getSkiResort()),
				entity.getTypeTicket(),entity.getUsingPeriod(), entity.getTransportType(),
				entity.getUsingStart(), entity.getUsingEnd(), entity.getInitialPrice(),
				users, entity.getBill(), purchasedPolicies);
	}
	
	public static Tickets toEntity (TicketsDTO dto) {
		int numOfChildren = 0;
		int numOfAdult = 0;
		int numOfSenior = 0;
		
		for(TicketUserDTO t: dto.getTicketUsers()) {
			
			switch(t.getUserType()) {
				case CHILD:
					numOfChildren = t.getCount();
					break;
				case ADULT:
					numOfAdult = t.getCount();
					break;
				case SENIOR:
					numOfSenior = t.getCount();
					break;
			}
		}
		
		
		
		return new Tickets(dto.getId(), SkiResortMapper.toEntity(dto.getSkiResort()),
				dto.getTypeTicket(),dto.getUsingPeriod(), dto.getTransportType(),
				dto.getUsingStart(), dto.getUsingEnd(), dto.getInitialPrice(),
				numOfChildren, numOfAdult, numOfSenior, dto.getBill());
	}
}
