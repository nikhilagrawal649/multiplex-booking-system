package com.multiplex;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multiplex.dao.MoviesRepository;
import com.multiplex.dao.ShowsRepository;
import com.multiplex.dao.UsersRepository;
import com.multiplex.entity.Movies;

@SpringBootTest
class TicketBookingApplicationTests {
	@Autowired
	MoviesRepository movierepo;
	@Autowired
	UsersRepository userrepo;
	@Autowired
	ShowsRepository showsrepositary;
	@Test
	void testMovies() {
		Movies movie = new Movies();
		movie.setMovieId(6);
		movie.setMovieName("rrr");
		movierepo.save(movie);
		assertNotNull(movierepo.findById(6).get());
	}

	@Test
	void testGetShow(){
		assertNotNull(showsrepositary.findById(1));
	}

}
