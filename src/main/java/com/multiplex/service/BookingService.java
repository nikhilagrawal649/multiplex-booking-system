package com.multiplex.service;

import com.multiplex.entity.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {

    public Boolean addBooking(Booking booking);
    public Boolean updateBooking(Booking booking);

    public boolean cancelBooking(Integer id);

    public List<?> getAllBooking();

    public Optional<Booking> getBooking(Integer id);

}
