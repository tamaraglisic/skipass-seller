package com.project.sellerapp.helpers;

import java.util.HashSet;
import java.util.Set;

import com.project.sellerapp.dto.TicketUserDTO;
import com.project.sellerapp.dto.TicketsDTO;
import com.project.sellerapp.model.Tickets;

public class TicketsMapper {

	public static TicketsDTO toDto (Tickets entity) {
		Set<TicketUserDTO> users = new HashSet<TicketUserDTO>();
		users.add(new TicketUserDTO("DECA", entity.getNumOfChildren(), 0.0));
		users.add(new TicketUserDTO("ODRASLI", entity.getNumOfAdult(), 0.0));
		users.add(new TicketUserDTO("SENIOR", entity.getNumOfSenior(), 0.0));

//		if(entity.getTicketUsers() != null) {
//			for(TicketUser t: entity.getTicketUsers()) {
//				users.add(TicketUserMapper.toDto(t));
//			}
//		}
//	
		return new TicketsDTO(entity.getId(), SkiResortMapper.toDto(entity.getSkiResort()),
				entity.getTypeTicket(),entity.getUsingPeriod(), entity.getTransportType(),
				entity.getUsingStart(), entity.getUsingEnd(), entity.getInitialPrice(),
				users, entity.getBill());
	}
	
	public static Tickets toEntity (TicketsDTO dto) {
		int numOfChildren = 0;
		int numOfAdult = 0;
		int numOfSenior = 0;
		
		for(TicketUserDTO t: dto.getTicketUsers()) {
			
			switch(t.getUserType()) {
				case "DECA":
					numOfChildren = t.getCount();
					break;
				case "ODRASLI":
					numOfAdult = t.getCount();
					break;
				case "SENIOR":
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
