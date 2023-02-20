package com.multiplex.dtotoentity;

import org.springframework.stereotype.Component;

import com.multiplex.dto.SeatTypeDTO;
import com.multiplex.entity.SeatType;

@Component
public class SeatTypeDtoToEntity {
	 public SeatType convertSeatTypeDtoToEntity(SeatTypeDTO seatTypeDto) {
		 SeatType st = new SeatType();
		 st.setSeatFare(seatTypeDto.getSeatFare());
		 st.setSeatTypeDesc(seatTypeDto.getSeatTypeDesc());
		 st.setSeatTypeId(seatTypeDto.getSeatTypeId());
		 
		 return st;
	 }
}
