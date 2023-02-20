package com.multiplex.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.dao.SeatTypeRepository;
import com.multiplex.entity.SeatType;
import com.multiplex.service.SeatTypeService;

@Service
public class SeatTypeServiceImpl implements SeatTypeService {
	@Autowired
	SeatTypeRepository seatTypeRepo;

	@Override
	public Boolean addSeatType(SeatType seattype) {
		if (seattype.getSeatFare() >= 0 && !seattype.getSeatTypeDesc().isEmpty() && seattype.getSeatTypeId() != 0) {
			seatTypeRepo.save(seattype);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<SeatType> getAllSeattype() {
		List<SeatType> seattype = (List<SeatType>) seatTypeRepo.findAll();
		return seattype;
	}
	
	@Override
	public Optional<SeatType> getSeattypeById(int id) {
		Optional<SeatType> seattype = seatTypeRepo.findById(id);
		return seattype;
	}
	
	@Override
	public String DeleteSeatType(int id) {
		seatTypeRepo.deleteById(id);
		return "Succesfully deleted";
	}

	public SeatType UpdateSeatType(SeatType updatedSeatType) {
		seatTypeRepo.save(updatedSeatType);
		return updatedSeatType;
	}

}
