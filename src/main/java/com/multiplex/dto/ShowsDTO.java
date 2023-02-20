package com.multiplex.dto;

import java.util.Date;

import com.multiplex.entity.Hall;
import com.multiplex.entity.Movies;

public class ShowsDTO {

	private Integer showId;

	private Hall hall;

	private Movies movie;
	private Integer slotNo;
	private Date fromDate;
	private Date toDate;

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public Movies getMovie() {
		return movie;
	}

	public void setMovie(Movies movie) {
		this.movie = movie;
	}

	public Integer getShowId() {
		return showId;
	}

	public void setShowId(Integer showId) {
		this.showId = showId;
	}

	public Integer getSlotNo() {
		return slotNo;
	}

	public void setSlotNo(Integer slotNo) {
		this.slotNo = slotNo;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

}
