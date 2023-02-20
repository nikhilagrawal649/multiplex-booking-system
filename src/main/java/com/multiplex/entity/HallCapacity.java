package com.multiplex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Hall_Capacity_Master")
public class HallCapacity{
	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer hallCapacityId;
	@ManyToOne
	
	@JoinColumn(name = "hall_id", referencedColumnName="hallId")
	private Hall halls;
	@ManyToOne
	@JoinColumn(name = "seat_type_id",referencedColumnName = "seatTypeId")
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