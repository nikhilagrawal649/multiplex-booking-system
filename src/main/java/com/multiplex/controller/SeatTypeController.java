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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.dto.SeatTypeDTO;
import com.multiplex.dtotoentity.SeatTypeDtoToEntity;
import com.multiplex.entity.SeatType;
import com.multiplex.exception.SeatTypeNotFoundException;
import com.multiplex.exceptionhandler.Constants;
import com.multiplex.service.SeatTypeService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class SeatTypeController {
	@Autowired
	SeatTypeService seatTypeService;
	@Autowired
	SeatTypeDtoToEntity seatTypeDtoToEntity;
	
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	//below method is use for Adding data by admin
	@PostMapping("/SeatTypes")
	public String addSeatType(@RequestBody @Valid SeatTypeDTO seattype)throws SeatTypeNotFoundException {

		boolean isSeatAdded = seatTypeService.addSeatType(seatTypeDtoToEntity.convertSeatTypeDtoToEntity(seattype));
		if (isSeatAdded) {
			return Constants.SUCCESS;
		} else {
			throw new SeatTypeNotFoundException("SeatTypeNotAdded Exception");
		}
	}
	//below method is use for fetching data by user
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	@GetMapping("/SeatTypes")
	public List<SeatType> getAllSeattype(){
		List<SeatType> seattype=seatTypeService.getAllSeattype();
		return seattype;
	}
	//below method is use for fetching data by Id 

	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	@GetMapping("/SeatTypes/{id}")
		public Optional<SeatType> getSeattypeById(@PathVariable("id")int id){
		return seatTypeService.getSeattypeById(id);
	}
	//below method is use for delete data by Id
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@DeleteMapping("/SeatTypes/{id}")
	public String DeleteSeatType(@PathVariable("id") int id) {
		seatTypeService.DeleteSeatType(id);
		return "Succesfully deleted";
	}
	//below method is use for update data
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@PutMapping("/SeatTypes")
	public SeatType UpdateSeatType(@RequestBody SeatType updatedSeatType){
		return seatTypeService.UpdateSeatType( updatedSeatType);
	}

}
