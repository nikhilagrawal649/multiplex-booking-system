package com.multiplex.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.multiplex.dao.SeatTypeRepository;
import com.multiplex.entity.SeatType;
import com.multiplex.serviceimpl.SeatTypeServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SeatTypeServiceTest {
	@Mock
	private SeatTypeRepository seatTypeRepo;
	@InjectMocks
	SeatTypeServiceImpl SeatTypeService;

	@Test
	@DisplayName("AddSeatType")
	void addSeatTypeTest() {
		SeatType seattype = createSeatTypeMockData();
		when(seatTypeRepo.save(seattype)).thenReturn(seattype);
		boolean response = SeatTypeService.addSeatType(seattype);
		assertEquals(response, true);
	}

	@Test
	@DisplayName("Get All SeatType")
	void getAllSeattype() {
		List<SeatType> seattype = new ArrayList<>();
		seattype.add(createSeatTypeMockData());
		when(seatTypeRepo.findAll()).thenReturn(seattype);
		List<SeatType> allSeatTypes = SeatTypeService.getAllSeattype();
		assertNotNull(allSeatTypes);
		assertEquals(allSeatTypes.size(), 1);
	}

	@Test
	@DisplayName("Delete seattype")
	void deleteSeatTest() {
		int seatTypeId = 4;
		doNothing().when(seatTypeRepo).deleteById(seatTypeId);
		String response = SeatTypeService.DeleteSeatType(seatTypeId);
		assertEquals(response, "Succesfully deleted");
	}
	
	@Test
	@DisplayName("Update Student")
	void updateSeatTypeTes() {
		SeatType seattype=createSeatTypeMockData();
		when(seatTypeRepo.save(seattype)).thenReturn(seattype);
		SeatType response= SeatTypeService.UpdateSeatType(seattype);
		assertEquals(response.getSeatTypeDesc(),seattype.getSeatTypeDesc());
		}
	
	private SeatType createSeatTypeMockData() {
		SeatType seattype = new SeatType();
		seattype.setSeatTypeId(4);
		seattype.setSeatTypeDesc("This is hall 1");seattype.setSeatFare(675);
		return seattype;
		}
}

