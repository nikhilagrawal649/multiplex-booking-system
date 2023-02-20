package com.multiplex.dtotoentity;

import org.springframework.stereotype.Component;

import com.multiplex.dto.ShowsDTO;
import com.multiplex.entity.Shows;

@Component
public class ShowsDtoToEntity {
	public Shows convertShowsDtoToEntity(ShowsDTO showsDTO) {
		Shows shows = new Shows();
		shows.setFromDate(showsDTO.getFromDate());
		shows.setHall(showsDTO.getHall());
		shows.setMovie(showsDTO.getMovie());
		shows.setShowId(showsDTO.getShowId());
		shows.setSlotNo(showsDTO.getSlotNo());
		shows.setToDate(showsDTO.getToDate());
		
		
		return shows;
		
	}

}