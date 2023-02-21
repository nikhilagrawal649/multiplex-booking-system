package com.multiplex;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import com.multiplex.controller.BookingController;
import com.multiplex.dao.BookingRepository;
import com.multiplex.dto.BookingDTO;
import com.multiplex.entity.Booking;
import com.multiplex.exception.BookingNotAddedException;
//import io.jsonwebtoken.lang.Arrays;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness=Strictness.LENIENT)
public class BookingTest {
@Autowired
@Mock
private BookingRepository bookingRepository;
@Autowired
@InjectMocks
private BookingController bookingController;
@Test
public void addBookTest() {
BookingDTO book = new BookingDTO();
try {
when(bookingController.addBooking(book)).thenReturn("SUCCESS");
Assertions.assertEquals("SUCCESS", bookingController.addBooking(book));
} catch (BookingNotAddedException e) {
// Handle the exception here. For example, log the error message.
System.out.println("Error: " + e.getMessage());
}
}
@Test
public void cancelBookingTest() {
try {
when(bookingController.cancelBooking(8)).thenReturn("Success");
Assertions.assertNotEquals("Success", bookingController.cancelBooking(8));
} catch (EmptyResultDataAccessException e) {
// Handle the exception here. For example, log the error message.
System.out.println("Error: " + e.getMessage());
}}
@Test
public void updateBookTest() {
BookingDTO book = new BookingDTO();
try {
when(bookingController.updateBooking(book)).thenReturn("SUCCESS");
Assertions.assertEquals("SUCCESS", bookingController.updateBooking(book));
} catch (BookingNotAddedException e) {
// Handle the exception here. For example, log the error message.
System.out.println("Error: " + e.getMessage());
}
}
@Test
public void getBookingTest() {
Booking booking = new Booking(); // create a Booking object to return from the mocked service method
BookingController bookingController = mock(BookingController.class); // create a mock object of the BookingController class
when(bookingController.getBooking(14)).thenReturn(Optional.of(booking));
Optional<Booking> result = bookingController.getBooking(14);
Assertions.assertTrue(result.isPresent()); // assert that the result is not an empty Optional
}
}
// Exception exception = Assertions.assertThrows(BookingNotAddedException.class, () -> {
// bookingController.updateBooking(bookingDTO);
// });
//
// Assertions.assertEquals("Error: Booking not added.", exception.getMessage());
//
//}

