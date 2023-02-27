package com.multiplex.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import com.multiplex.dao.ShowsRepository;
import com.multiplex.entity.Hall;
import com.multiplex.entity.HallCapacity;
import com.multiplex.entity.Movies;
import com.multiplex.entity.Shows;
import com.multiplex.exception.ShowException;
import com.multiplex.serviceimpl.ShowServiceImpl;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ShowServiceTest {

	
	@Mock
	private ShowsRepository showsrepositary;
	
	
	@InjectMocks
	ShowServiceImpl showService;
	
	
	
	
	
	
	@Test
	@DisplayName("Add Show")
	void addShowTest()
	{
		Shows show = createShowMockData();
	    when(showsrepositary.save(show)).thenReturn(show);	
		String response = showService.addShow(show);
		assertEquals(response, "Show added successfully");
	}
	
	
	
	
	@Test
	@DisplayName("Get Show By Id")
	void getshowByIdTest() 
	{
		try 
		{
		Integer showId=7;
		Shows show = createShowMockData();
	    when(showsrepositary.findById(showId)).thenReturn(Optional.of(show));	
		Shows response = showService.getShowId(showId);
		assertEquals(response.getMovie().getMovieId(), show.getMovie().getMovieId());
		assertEquals(response.getHall().getHallId(), show.getHall().getHallId());
		}
		catch(ShowException e) 
		{
			System.out.println("ERROR:" +e.getMessage());
		}
	}
	
	
	@Test
	@DisplayName("Get All Shows")
	void getAllShowsTest() 
	{
		try 
		{
		List<Shows> show = new ArrayList<>();
		show.add(createShowMockData());
		when(showsrepositary.findAll()).thenReturn(show);
		List<Shows> allShows = showService.getAllShows();
		assertNotNull(allShows);
		assertEquals(allShows.size(), 1);
		}
		catch(ShowException e) 
		{
			System.out.println("ERROR:" +e.getMessage());
		}
	}
	
	
	
	@Test
    @DisplayName("Updated Show")
    void updateShowTest() 
	{
        Shows shows = createShowMockData();
        when(showsrepositary.save(shows)).thenReturn(shows);
        Shows response = showService.updatedShow(shows);
        assertEquals(response.getShowId(),shows.getShowId());

    }
	
		
@Test
@DisplayName("Delete Show")
void deleteShowTest() 
{
	int showId = 2;
	doNothing().when(showsrepositary).deleteById(showId);
	String response = showService.deleteShow(showId);
	assertEquals(response, "Show deleted");
}
	

	private Shows createShowMockData() 
	{
		// TODO Auto-generated method stub
     	Shows show = new Shows();
		show.setMovie(createShowMockDataMovie());
		show.setHall(createShowMockDataHall());
		return show;

	}
	
private Hall createShowMockDataHall() 
{
	 Hall hall = new Hall();
	 hall.setHallId(11);
     return hall;
}



private Movies createShowMockDataMovie() 
{
	Movies movie = new Movies();
	movie.setMovieId(1);
	movie.setMovieName("RRR");
	return movie;
}
	
	
	
}
