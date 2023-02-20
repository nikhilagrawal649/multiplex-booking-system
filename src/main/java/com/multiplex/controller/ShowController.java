package com.multiplex.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.multiplex.dto.ShowsDTO;
import com.multiplex.dtotoentity.ShowsDtoToEntity;
import com.multiplex.entity.Shows;
import com.multiplex.exception.ShowException;
import com.multiplex.service.ShowService;

@RestController
public class ShowController {
	@Autowired
	ShowService showservice;
	@Autowired
	ShowsDtoToEntity showsDtoToEntity;

	@PostMapping(value = "/api/shows")
	public String addMovie(@RequestBody ShowsDTO shows){
		showservice.addShow(showsDtoToEntity.convertShowsDtoToEntity(shows));
		return "";
		
	}

	@GetMapping("/api/shows/{showId}")
	public Shows getshowById(@PathVariable Integer showId) {
		Shows show = showservice.getShowId(showId);
		if(show!=null) {
			return show;
		}else {
			throw new ShowException();
		}
		
	}
	// @CrossOrigin

	@GetMapping("/api/shows")
	public List<Shows> getAllShows() {
		List<Shows> shows = showservice.getAllShows();
		if(shows!=null) {
			return shows;
		}else {
			throw new ShowException();
		}
	}
	@DeleteMapping("/api/shows/{showId}")
	public String deleteShow(@PathVariable("showId") Integer showId)
	{
		showservice.deleteShow(showId);
		return "Show deleted";
	}
	
	
}