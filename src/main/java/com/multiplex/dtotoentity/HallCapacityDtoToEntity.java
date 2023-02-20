package com.multiplex.dtotoentity;

import org.springframework.stereotype.Component;

import com.multiplex.dto.HallCapacityDTO;
import com.multiplex.entity.HallCapacity;

@Component
public class HallCapacityDtoToEntity {
	public HallCapacity convertHallCapacityDtoToEntity(HallCapacityDTO hallCapacityDTO) {
		HallCapacity hallCapacity = new HallCapacity();
		hallCapacity.setHallCapacityId(hallCapacityDTO.getHallCapacityId());
		hallCapacity.setHalls(hallCapacityDTO.getHalls());
		hallCapacity.setSeatCount(hallCapacityDTO.getHallCapacityId());
		hallCapacity.setSeatType(hallCapacityDTO.getSeatType());
		return hallCapacity;
		
		
	}

}