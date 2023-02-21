package com.multiplex.serviceimpl;

import com.multiplex.dao.BookingRepository;
import com.multiplex.entity.Booking;
import com.multiplex.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
	public Boolean updateBooking(Booking booking) {
		if (booking.getShows() != null && booking.getBookingId() != null && booking.getUser() != null
				&& booking.getBookedDate() != null && booking.getShowDate() != null) {
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

	@Override
	public List<?> getAllBooking() {
		return bookingRepo.findAll();
	}

	@Override
	public Optional<Booking> getBooking(Integer id) {
		return bookingRepo.findById(id);
	}

}