package com.multiplex.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.dao.HallRepository;
import com.multiplex.entity.Hall;
import com.multiplex.service.HallService;

@Service
public class HallServiceImpl implements HallService {
@Autowired
HallRepository hallrepositary;
	@Override
	public String addHall(Hall hall) {
		 hallrepositary.save(hall);
		 return "Successfully added";
	}
	
	@Override
	public List<Hall> getAllHalls(){
		return hallrepositary.findAll();
	}
	
	@Override
	public Hall updatedHall(Hall updatedHall) {
		return hallrepositary.save(updatedHall);
	}
	
	@Override 
	public String deleteHall(Integer hallId) {
		hallrepositary.deleteById(hallId);
		return "Hall deleted";
	}
	
	

}
