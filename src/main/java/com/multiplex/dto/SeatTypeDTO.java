package com.multiplex.dto;

public class SeatTypeDTO {
	//@NotNull(message="hallId required")
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
}