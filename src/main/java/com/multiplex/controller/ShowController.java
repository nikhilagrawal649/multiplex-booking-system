package com.multiplex.controller;

import java.net.http.HttpHeaders;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.multiplex.dto.ShowsDTO;
import com.multiplex.dtotoentity.ShowsDtoToEntity;
import com.multiplex.entity.Hall;
import com.multiplex.entity.Shows;
import com.multiplex.exception.ShowException;
import com.multiplex.service.ShowService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api")
public class ShowController {
	@Autowired
	ShowService showservice;
	@Autowired
	ShowsDtoToEntity showsDtoToEntity;
	
	

	@PostMapping(value = "/shows")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	//THIS METHOD IS USED TO ADD A SHOW
	public ResponseEntity<ShowsDTO> addShow(@RequestBody @Valid ShowsDTO shows) 
	{
		
		showservice.addShow(showsDtoToEntity.convertShowsDtoToEntity(shows));
		 
	        return new ResponseEntity<ShowsDTO>(shows,HttpStatus.OK);
		//return "Added";
	}
	

	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value="hasRole('ROLE_ADMIN') || hasRole('ROLE_USER')")
	@GetMapping("/shows/{showId}")
	//THIS METHOD IS USED TO GET A PARTICULAR SHOW BY ID
	public ResponseEntity<Shows> getshowById(@PathVariable Integer showId) 
	{
	Shows show = showservice.getShowId(showId);
		if (show != null) {
			return new ResponseEntity<Shows>(show,HttpStatus.OK);
		} else {
			throw new ShowException();
		}
	}
	
	

	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value="hasRole('ROLE_ADMIN') || hasRole('ROLE_USER')")
	@GetMapping("/shows")
	//THIS METHOD IS USED TO GET ALL THE SHOWS
	public ResponseEntity<List<Shows>> getAllShows() 
	{
		List<Shows> shows = showservice.getAllShows();
			if (shows != null) {
				return new ResponseEntity<List<Shows>>(shows,HttpStatus.OK);
			} else {
				throw new ShowException();
			}
		}
	
	
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/shows")
	//THIS METHOD IS USED TO UPDATE A SHOW
	public ResponseEntity<Shows> updateShow(@RequestBody Shows updatedShow) 
	{
		Shows show = showservice.updatedShow(updatedShow);	
		return new ResponseEntity<Shows>(show,HttpStatus.OK);
	}
	
	
	
	
	
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@DeleteMapping("/shows/{showId}")
	//THIS METHOD IS USED TO DELETE A PARTICULAR SHOW BY ID
	public ResponseEntity<String> deleteShow(@PathVariable("showId") Integer showId) 
	{
		showservice.deleteShow(showId);
		return new ResponseEntity<String>("Show Deleted" ,HttpStatus.OK);
	}
	

}


