package com.multiplex.dto;

import com.multiplex.entity.Hall;
import com.multiplex.entity.SeatType;

public class HallCapacityDTO {

	private int hallCapacityId;

	private Hall halls;

	private SeatType seatType;
	private Integer seatCount;

	public Integer getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}

	public Integer getHallCapacityId() {
		return hallCapacityId;
	}

	public void setHallCapacityId(Integer hallCapacityId) {
		this.hallCapacityId = hallCapacityId;
	}

	public Hall getHalls() {
		return halls;
	}

	public void setHalls(Hall halls) {
		this.halls = halls;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}

}