package com.multiplex.serviceimpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.dao.HallCapacityRepository;
import com.multiplex.entity.HallCapacity;
import com.multiplex.entity.SeatType;
import com.multiplex.exception.HallCapacityException;
import com.multiplex.service.HallCapacityService;

@Service
public class HallCapacityServiceImpl implements HallCapacityService {
	@Autowired
	HallCapacityRepository hallCapacityRepo;

	@Override
	public String addHallCapacity(HallCapacity hallcapa) {
		hallCapacityRepo.save(hallcapa);
		return "Successfully added";
	}

	@Override
	public List<HallCapacity> getAllHallCapacity() {
		List<HallCapacity> hallCapacity = (List<HallCapacity>) hallCapacityRepo.findAll();
		return hallCapacity;
	}

	@Override
	public HallCapacity getHallCapacityById(int hallCapacityId) {
		return hallCapacityRepo.findById(hallCapacityId).orElseThrow(HallCapacityException::new);
	}

	@Override
	public HallCapacity updatedHallCapacity(HallCapacity updatedHallCapacity) {
		return hallCapacityRepo.save(updatedHallCapacity);
	}

	@Override
	public String deleteHallCapacity(Integer hallCapacityId) {
		hallCapacityRepo.deleteById(hallCapacityId);
		return "Successfully deleted";
	}

}
