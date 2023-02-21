package com.multiplex.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.dto.HallCapacityDTO;
import com.multiplex.dtotoentity.HallCapacityDtoToEntity;
import com.multiplex.entity.HallCapacity;
import com.multiplex.exception.HallCapacityException;
import com.multiplex.exception.SeatCountNotZeroException;
import com.multiplex.service.HallCapacityService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class HallCapacityController {
	@Autowired
	HallCapacityService hallCapacityservice;
	@Autowired
	HallCapacityDtoToEntity hallCapacityDtoToEntity;

	@Validated

	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	//below method is used for adding data by admin
	@PostMapping("/HallCapacities")
	public String addHallCapacity(@RequestBody @Valid HallCapacityDTO hallcapa) throws SeatCountNotZeroException {

		HallCapacity hallCapacity = new HallCapacity();
		hallCapacity.setHallCapacityId(hallcapa.getHallCapacityId());
		hallCapacity.setHalls(hallcapa.getHalls());
		if(hallcapa.getSeatCount()==0) {
			throw new SeatCountNotZeroException("Seat count couldn't be zero");
		}
		else {
			hallCapacity.setSeatCount(hallcapa.getSeatCount());
		}
		
		
		hallCapacity.setSeatType(hallcapa.getSeatType());
		hallCapacityservice.addHallCapacity(hallCapacity);
		
		
		return "Success";

	}

    @SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
    //below method is used for fetching data by user 
	@GetMapping("/HallCapacities")
	public List<HallCapacity> getAllHallCapacity() {
		List<HallCapacity> hallCapacity = hallCapacityservice.getAllHallCapacity();
		if (hallCapacity != null) {
			return hallCapacity;
		} else {
			throw new HallCapacityException();
		}
	}

    @SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
    //below method is used for fetching data by id
	@GetMapping("/HallCapacities/{id}")
	public HallCapacity getHallCapacityById(@PathVariable("id") int id) {
		return hallCapacityservice.getHallCapacityById(id);
	}

    @SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    //below method is used to update the data
	@PutMapping("/HallCapacities")
	public HallCapacity updateHallCapacity(@RequestBody HallCapacity updatedHallCapacity) {
		return hallCapacityservice.updatedHallCapacity(updatedHallCapacity);
	}

    @SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    //below method is used to delete data by id 
	@DeleteMapping("/HallCapacities/{hallCapacityId}")
	public String deleteHallCapacity(@PathVariable Integer hallCapacityId) {
		hallCapacityservice.deleteHallCapacity(hallCapacityId);
		return "Successfully deleted";
	}

}


