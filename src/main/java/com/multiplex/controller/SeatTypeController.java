package com.multiplex.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.dto.SeatTypeDTO;
import com.multiplex.dtotoentity.SeatTypeDtoToEntity;
import com.multiplex.entity.SeatType;
import com.multiplex.exceptionhandler.Constants;
import com.multiplex.service.SeatTypeService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
public class SeatTypeController {
	@Autowired
	SeatTypeService seatTypeService;
	@Autowired
	SeatTypeDtoToEntity seatTypeDtoToEntity;
	
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@PostMapping("/api/SeatTypes")
	public String addSeatType(@RequestBody SeatTypeDTO seattype) {

		boolean isSeatAdded = seatTypeService.addSeatType(seatTypeDtoToEntity.convertSeatTypeDtoToEntity(seattype));
		if (isSeatAdded) {
			return Constants.SUCCESS;
		} else {
			return Constants.FAILED;
		}
	}
	
//	@SecurityRequirement(name = "Bearer Authentication")
//	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@GetMapping("/api/SeatTypes")
	public List<SeatType> getAllSeattype(){
		List<SeatType> seattype=seatTypeService.getAllSeattype();
		return seattype;
	}
	
//	@SecurityRequirement(name = "Bearer Authentication")
//	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@GetMapping("/api/SeatTypes/{id}")
		public Optional<SeatType> getSeattypeById(@PathVariable("id")int id){
		return seatTypeService.getSeattypeById(id);
	}
	
//	@SecurityRequirement(name = "Bearer Authentication")
//	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@DeleteMapping("/api/SeatTypes/{id}")
	public String DeleteSeatType(@PathVariable("id") int id) {
		seatTypeService.DeleteSeatType(id);
		return "Succesfully deleted";
	}
	
//	@SecurityRequirement(name = "Bearer Authentication")
//	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@PutMapping("/api/SeatTypes")
	public SeatType UpdateSeatType(@RequestBody SeatType updatedSeatType){
		return seatTypeService.UpdateSeatType( updatedSeatType);
	}

}
