package com.multiplex.dtotoentity;

import org.springframework.stereotype.Component;

import com.multiplex.dto.BookingDTO;
import com.multiplex.entity.Booking;

@Component
public class BookingDtoToEntity {
	public Booking convertbookingDtoToEntity(BookingDTO bookingDTO) {
		Booking booking = new Booking();
		booking.setBookedDate(bookingDTO.getBookedDate());
		booking.setBookingId(bookingDTO.getBookingId());
		booking.setShowDate(bookingDTO.getShowDate());
		booking.setShows(bookingDTO.getShows());
		booking.setUser(bookingDTO.getUser());
		booking.setNoOfSeats(bookingDTO.getNoOfSeats());
		booking.setSeatType(bookingDTO.getSeatType());
		return booking;
	
	}
	
	
}
