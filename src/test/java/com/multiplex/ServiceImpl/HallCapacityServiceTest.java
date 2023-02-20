package com.multiplex.ServiceImpl;
 
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
 
import com.multiplex.dao.HallCapacityRepository;
import com.multiplex.entity.Hall;
import com.multiplex.entity.HallCapacity;
import com.multiplex.entity.SeatType;
import com.multiplex.serviceimpl.HallCapacityServiceImpl;
 
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class HallCapacityServiceTest {

    @Mock
    private HallCapacityRepository hallCapacityRepo;

    @InjectMocks
    private HallCapacityServiceImpl hallCapacityService;

    @Test
    @DisplayName("AddCapacity")
    void addHallCapacityTest() {
        HallCapacity hallCapacity = createHallCapacityMockData();
        when(hallCapacityRepo.save(hallCapacity)).thenReturn(hallCapacity);
        String response = hallCapacityService.addHallCapacity(hallCapacity);
        assertEquals(response,"Successfully added");
    }


    @Test
    @DisplayName("Get HallCapacityById")
    void getHallCapacityByIdTest() {
        Integer hallCapacityId=7;
        HallCapacity hallCapacity = createHallCapacityMockData();
        when(hallCapacityRepo.findById(hallCapacityId)).thenReturn(Optional.of(hallCapacity));
        HallCapacity response = hallCapacityService.getHallCapacityById(hallCapacityId);
        assertEquals(response.getSeatType().getSeatTypeId(), hallCapacity.getSeatType().getSeatTypeId());
    }

    @Test
    @DisplayName("Get AllHallCapacity")
    void getAllHallCapacity() {
        List<HallCapacity>hallCapacity = new ArrayList<>();
        hallCapacity.add(createHallCapacityMockData());
        when(hallCapacityRepo.findAll()).thenReturn(hallCapacity);
        List<HallCapacity>allHallCapacities = hallCapacityService.getAllHallCapacity();
        assertNotNull(allHallCapacities);
        assertEquals(allHallCapacities.size(),1);
    }

    @Test
    @DisplayName("UpdateHallCapacity")
    void updateHallCapacityTest() {
        HallCapacity hallCapacity = createHallCapacityMockData();
        when(hallCapacityRepo.save(hallCapacity)).thenReturn(hallCapacity);
        HallCapacity response = hallCapacityService.updatedHallCapacity(hallCapacity);
        assertEquals(response.getHallCapacityId(),hallCapacity.getHallCapacityId());

    }

    @Test
    @DisplayName("DeleteHallCapacity")
    void deleteHallCapacityTest() {
        int HallCapacityId = 12;
        doNothing().when(hallCapacityRepo).deleteById(HallCapacityId);
        String response = hallCapacityService.deleteHallCapacity(HallCapacityId);
        assertEquals(response,"Successfully deleted");
    }

    private HallCapacity createHallCapacityMockData() {
        HallCapacity hallCapacity = new HallCapacity();
        hallCapacity.setHallCapacityId(12);
        hallCapacity.setHalls(createHallCapacityMockDataHall());
        hallCapacity.setSeatType(createHallCapacityMockDataSeatType());
        return hallCapacity;
    }

    private Hall createHallCapacityMockDataHall() {
        Hall hall = new Hall();
        hall.setHallId(12);
        return hall;
    }


    private SeatType createHallCapacityMockDataSeatType()
    {
        SeatType seatType = new SeatType();
        seatType.setSeatTypeId(23);
        return seatType;
    }

}

