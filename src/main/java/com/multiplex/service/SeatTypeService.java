package com.multiplex.service;

import java.util.List;
import java.util.Optional;

import com.multiplex.entity.SeatType;

public interface SeatTypeService {
	public Boolean addSeatType(SeatType seattype);
	public List<SeatType> getAllSeattype();
	public Optional<SeatType> getSeattypeById(int id);
	public String DeleteSeatType(int id);
	public SeatType UpdateSeatType(SeatType updatedSeatType);}
