package com.multiplex.dtotoentity;

import org.springframework.stereotype.Component;

import com.multiplex.dto.MoviesDTO;
import com.multiplex.entity.Movies;

@Component
public class MovieDtoToEntity {
	public Movies convertMovieDtoToEntity(MoviesDTO moviesDTO) {
		Movies movies = new Movies();
		movies.setMovieId(moviesDTO.getMovieId());
		movies.setMovieName(moviesDTO.getMovieName());
		return movies;
	}
}
