package com.multiplex.dtotoentity;

import org.springframework.stereotype.Component;

import com.multiplex.dto.HallDTO;
import com.multiplex.entity.Hall;

@Component
public class HallDtoToEntity {
	public Hall convertHallDtoToEntity(HallDTO hallDTO) {
		Hall hall =  new Hall();
		hall.setHallDesc(hallDTO.getHallDesc());
		hall.setHallId(hallDTO.getHallId());
		hall.setTotalCapacity(hallDTO.getTotalCapacity());
		
		return hall;
	}
}
