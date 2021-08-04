package com.project.sellerapp.helpers;

import com.project.sellerapp.dto.TicketUserDTO;
import com.project.sellerapp.model.TicketUser;

public class TicketUserMapper {

	public static TicketUserDTO toDto (TicketUser entity) {
		
		return new TicketUserDTO(entity.getId(), entity.getUserType(), entity.getCount(),
				entity.getSingleTicketPrice());
	}
	
	public static TicketUser toEntity (TicketUserDTO dto) {
		
		return new TicketUser(dto.getId(), dto.getUserType(), dto.getCount(),
				dto.getSingleTicketPrice());
	}
}
