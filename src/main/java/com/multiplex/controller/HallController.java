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
import org.springframework.web.bind.annotation.RestController;
import com.multiplex.dto.HallDTO;
import com.multiplex.dtotoentity.HallDtoToEntity;
import com.multiplex.entity.Hall;
import com.multiplex.exception.HallException;
import com.multiplex.service.HallService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
public class HallController {
	@Autowired
	HallService hallservce;
	@Autowired
	HallDtoToEntity hallDtoToEntity;

	@Validated
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@PostMapping(value = "/api/halls")
	public String addMovie(@RequestBody @Valid HallDTO hall) {
		hallservce.addHall(hallDtoToEntity.convertHallDtoToEntity(hall));
		return "added successfully";
	}
	
//	@SecurityRequirement(name = "Bearer Authentication")
//	@PreAuthorize(value = "hasRole('ROLE_USER')")
	@GetMapping(value = "/api/halls")
	public List<Hall> getAllHalls(){
		return hallservce.getAllHalls();		
	}
	
//	@SecurityRequirement(name = "Bearer Authentication")
//	@PreAuthorize(value = "hasRole('ROLE_USER')")
	@PutMapping(value = "/api/halls")
	public Hall updateHall(@RequestBody Hall updatedHall) {
		return hallservce.updatedHall(updatedHall);		
	}
	
//	@SecurityRequirement(name = "Bearer Authentication")
//	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@DeleteMapping(value = "/api/halls/{hallId}")
	public String deletehall(@PathVariable Integer hallId) {
		hallservce.deleteHall(hallId);
		if(hallId!=null) {
			return "Sucessfully Deleted" ;
		}else {
			throw new HallException();
		}
	}
}