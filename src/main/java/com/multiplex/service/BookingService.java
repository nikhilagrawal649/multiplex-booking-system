package com.multiplex.service;

import com.multiplex.entity.Booking;

public interface BookingService {

	public Boolean addBooking(Booking booking);

	public boolean cancelBooking(Integer id);

}
