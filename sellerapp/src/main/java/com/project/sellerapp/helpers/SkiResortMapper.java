package com.project.sellerapp.helpers;

import com.project.sellerapp.dto.SkiResortDTO;
import com.project.sellerapp.model.SkiResort;

public class SkiResortMapper {
	
	public static SkiResortDTO toDto (SkiResort entity) {
		return new SkiResortDTO(entity.getId(), entity.getName(), entity.getDescription(),
				entity.getCountry(), entity.getLiftPrice(), entity.getGondolaPrice(), entity.getSeasonStarts(), 
				entity.getSeasonEnds(), entity.getGroupCount(), entity.getTicketDeposit(),
				entity.getCapacity(), entity.isActive());
	}

	public static SkiResort toEntity (SkiResortDTO dto) {
		return new SkiResort(dto.getId(), dto.getName(), dto.getDescription(), dto.getCountry(),
				dto.getLiftPrice(), dto.getGondolaPrice(), dto.getSeasonStarts(), dto.getSeasonEnds(),
				dto.getGroupCount(), dto.getTicketDeposit(), dto.getCapacity(), dto.isActive());
	}
}
