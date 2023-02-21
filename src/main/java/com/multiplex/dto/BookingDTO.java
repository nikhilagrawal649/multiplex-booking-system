package com.multiplex.dto;

import java.util.Date;

import com.multiplex.entity.SeatType;
import com.multiplex.entity.Shows;
import com.multiplex.entity.User;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {

	private Integer bookingId;
    @NotNull
	private User user;
    
    @NotNull
	private Shows shows;
    
	@FutureOrPresent
	private Date bookedDate;
	
	@FutureOrPresent
	private Date showDate;
	
	@NotNull
	private SeatType seatType;
	
	@NotNull(message = "Seat Count Required")
	private Integer noOfSeats;

}
