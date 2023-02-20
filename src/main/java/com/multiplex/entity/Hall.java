package com.multiplex.entity;

import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity

public class Hall {
	@Id	
	private Integer hallId;
	private String hallDesc;
	private Integer totalCapacity;

	public Integer getHallId() {
		return hallId;
	}

	public void setHallId(Integer hallId) {
		this.hallId = hallId;
	}

	public String getHallDesc() {
		return hallDesc;
	}

	public void setHallDesc(String hallDesc) {
		this.hallDesc = hallDesc;
	}

	public Integer getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(Integer totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	@OneToMany(mappedBy = "hall", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Shows> shows;

	@OneToMany(mappedBy = "halls", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<HallCapacity> hallCapacity;

}