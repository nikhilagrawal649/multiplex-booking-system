package com.multiplex.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Shows {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer showId;
	@ManyToOne
	@JoinColumn(name = "hall_id")
	private Hall hall;
	@ManyToOne
	@JoinColumn(name = "movie_id")
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
	@OneToMany(mappedBy = "shows", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Booking> bookings;

}
