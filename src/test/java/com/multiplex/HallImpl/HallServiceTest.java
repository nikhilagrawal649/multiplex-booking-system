package com.multiplex.HallImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.multiplex.dao.HallRepository;
import com.multiplex.entity.Hall;
import com.multiplex.serviceimpl.HallServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class HallServiceTest {
	@Mock
	private HallRepository hallrepositary;
	
	@InjectMocks
	HallServiceImpl hallService;
	
	@Test
	@DisplayName("Add Hall")
	void addHallTest() {
		Hall hall = createHallMockData();
		when(hallrepositary.save(hall)).thenReturn(hall);
		String response = hallService.addHall(hall);
		assertEquals(response,"Successfully added");
	}

	
	
	@Test
	@DisplayName("Get All Halls")
	void getAllHallsTest() {
		List<Hall> hall = new ArrayList<>();
		hall.add(createHallMockData());
		when(hallrepositary.findAll()).thenReturn(hall);
		List<Hall> allHalls = hallService.getAllHalls();
		assertNotNull(allHalls);
		assertEquals(allHalls.size(),1);
	}
	
	@Test
	@DisplayName("Update Hall")
	void updateHallTest() {
		Hall hall = createHallMockData();
		when(hallrepositary.save(hall)).thenReturn(hall);
		Hall response = hallService.updatedHall(hall);
		assertEquals(response.getHallDesc(),hall.getHallDesc());
	}
	
	@Test
	@DisplayName("Delete Hall")
	void deleteHallTest(){
		int hallId = 1;
		doNothing().when(hallrepositary).deleteById(hallId);
		String response = hallService.deleteHall(hallId);
		assertEquals(response,"Hall deleted");
		
	}
	
	private Hall createHallMockData() {
		Hall hall = new Hall();
		hall.setHallId(1);
		hall.setHallDesc("This is VIP");
		return hall;
		
	}

}
