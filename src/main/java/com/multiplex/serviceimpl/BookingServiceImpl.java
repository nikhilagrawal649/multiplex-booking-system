package com.multiplex.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.dao.BookingRepository;
import com.multiplex.entity.Booking;
import com.multiplex.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	BookingRepository bookingRepo;

	@Override
	public Boolean addBooking(Booking booking) {
		if (booking.getShows() != null && booking.getUser() != null && booking.getBookedDate() != null
				&& booking.getShowDate() != null) {
			bookingRepo.save(booking);
			return true;
		}
		return false;
	}

	@Override
	public boolean cancelBooking(Integer id) {
		if (id != null) {
			bookingRepo.deleteById(id);
			return true;
		} else {
			return false;
		}

	}

}