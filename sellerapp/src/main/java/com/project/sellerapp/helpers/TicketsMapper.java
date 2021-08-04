package com.project.sellerapp.helpers;

import java.util.HashSet;
import java.util.Set;

import com.project.sellerapp.dto.TicketUserDTO;
import com.project.sellerapp.dto.TicketsDTO;
import com.project.sellerapp.model.TicketUser;
import com.project.sellerapp.model.Tickets;

public class TicketsMapper {

	public static TicketsDTO toDto (Tickets entity) {
		Set<TicketUserDTO> users = new HashSet<TicketUserDTO>();
		
		if(entity.getTicketUsers() != null) {
			for(TicketUser t: entity.getTicketUsers()) {
				users.add(TicketUserMapper.toDto(t));
			}
		}
	
		return new TicketsDTO(entity.getId(), SkiResortMapper.toDto(entity.getSkiResort()),
				entity.getTypeTicket(),entity.getUsingPeriod(), entity.getTransportType(),
				entity.getUsingStart(), entity.getUsingEnd(), entity.getInitialPrice(),
				users, entity.getBill());
	}
	
	public static Tickets toEntity (TicketsDTO dto) {
		
		Set<TicketUser> users = new HashSet<TicketUser>();
		
		if(dto.getTicketUsers() != null) {
			for(TicketUserDTO t: dto.getTicketUsers()) {
				users.add(TicketUserMapper.toEntity(t));
			}
		}
		
		return new Tickets(dto.getId(), SkiResortMapper.toEntity(dto.getSkiResort()),
				dto.getTypeTicket(),dto.getUsingPeriod(), dto.getTransportType(),
				dto.getUsingStart(), dto.getUsingEnd(), dto.getInitialPrice(),
				users, dto.getBill());
	}
}
