package com.multiplex.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class SeatType {
	@Id
	
	private Integer seatTypeId;
	private String seatTypeDesc;
	private float seatFare;

	public Integer getSeatTypeId() {
		return seatTypeId;
	}

	public void setSeatTypeId(Integer seatTypeId) {
		this.seatTypeId = seatTypeId;
	}

	public String getSeatTypeDesc() {
		return seatTypeDesc;
	}

	public void setSeatTypeDesc(String seatTypeDesc) {
		this.seatTypeDesc = seatTypeDesc;
	}

	public float getSeatFare() {
		return seatFare;
	}

	public void setSeatFare(float seatFare) {
		this.seatFare = seatFare;
	}

	@OneToMany(mappedBy = "seatType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<HallCapacity> hallCapacity;
}