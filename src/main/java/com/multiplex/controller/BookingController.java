package com.multiplex.controller;

import com.multiplex.dto.BookingDTO;
import com.multiplex.dtotoentity.BookingDtoToEntity;
import com.multiplex.entity.Booking;
import com.multiplex.exception.BookingNotAddedException;
import com.multiplex.exceptionhandler.Constants;
import com.multiplex.service.BookingService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//import javax.validation.Valid;

@RestController
public class BookingController {
    @Autowired
    BookingService bookingService;
    @Autowired
    BookingDtoToEntity bookingDtoToEntity;

    @CrossOrigin
    @PostMapping("/addbooking")
    public String addBooking(@RequestBody @Valid BookingDTO booking) throws BookingNotAddedException {
        boolean isBookingAdded = bookingService.addBooking(bookingDtoToEntity.convertbookingDtoToEntity(booking));
        if (isBookingAdded) {
            return Constants.SUCCESS;
        } else {
            throw new BookingNotAddedException();
        }
    }

    @CrossOrigin
    @PatchMapping("/updatebooking")
    public String updateBooking(@RequestBody BookingDTO booking) throws BookingNotAddedException {
        boolean isBookingAdded = bookingService.updateBooking(bookingDtoToEntity.convertbookingDtoToEntity(booking));
        if (isBookingAdded) {
            return Constants.SUCCESS;
        } else {
            throw new BookingNotAddedException();
        }
    }

    @PostMapping("/cancelBooking")
    public String cancelBooking(@RequestParam Integer id) {
        boolean isBookingAdded = bookingService.cancelBooking(id);
        if (isBookingAdded) {
            return Constants.SUCCESS;
        } else {
            return Constants.FAILED;
        }
    }

    @GetMapping("/getAllBooking")
    public List<?> getAllBooking() {
        return bookingService.getAllBooking();

    }

    @GetMapping("/getBooking")
    public Optional<Booking> getBooking(@RequestParam Integer id) {
        return bookingService.getBooking(id);

    }
}