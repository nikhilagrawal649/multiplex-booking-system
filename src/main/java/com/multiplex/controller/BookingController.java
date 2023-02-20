package com.multiplex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.dto.BookingDTO;
import com.multiplex.dtotoentity.BookingDtoToEntity;
import com.multiplex.exception.BookingNotAddedException;
import com.multiplex.exceptionhandler.Constants;
import com.multiplex.service.BookingService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
public class BookingController {
	@Autowired
    BookingService  bookingService;
	@Autowired
	BookingDtoToEntity bookingDtoToEntity;
	
	  @CrossOrigin 
	  @SecurityRequirement(name = "Bearer Authentication")
	  @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	  @PostMapping("/api/addbooking")
	  public String addBooking(@RequestBody BookingDTO booking) throws BookingNotAddedException {
		  boolean isBookingAdded=bookingService.addBooking(bookingDtoToEntity.convertbookingDtoToEntity(booking));
		  if(isBookingAdded) {
			  return Constants.SUCCESS;
		  }else {
			  throw new BookingNotAddedException();
		  }
		  }
		@SecurityRequirement(name = "Bearer Authentication")
		@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
		@PostMapping("/api/cancelBooking")
	  public String cancelBooking(@RequestParam Integer id) {
		  boolean isBookingAdded=bookingService.cancelBooking(id);
		  if(isBookingAdded) {
			  return Constants.SUCCESS;
		  }else {
			  return Constants.FAILED;
		  }
		  }

}
