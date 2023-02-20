package com.multiplex.service;

import java.util.List;
import com.multiplex.entity.Hall;

public interface HallService {
	public String addHall(Hall hall);

	List<Hall> getAllHalls();

	Hall updatedHall(Hall updatedHall);

	String deleteHall(Integer hallId);
}