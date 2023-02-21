package com.multiplex.dto;

import java.util.Date;

import com.multiplex.entity.Hall;
import com.multiplex.entity.Movies;

import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;



public class ShowsDTO {

	private Integer showId;

	@NotNull(message = "Hall is Required")
	private Hall hall;


	@NotNull(message = "Movie detail is Required")
	private Movies movie;
	
	@NotNull(message = "SlotNo is Required")
	private Integer slotNo;
	
	
    @NotNull(message = "Date is Required")
    @FutureOrPresent
	private Date fromDate;
	

    @NotNull(message = "Date is Required")
    @FutureOrPresent
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

//	public Object getHeaders() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
