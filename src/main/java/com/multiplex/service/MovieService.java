package com.multiplex.service;

import java.util.List;

import com.multiplex.entity.Movies;

public interface MovieService {
	public Movies addMovie(Movies movies);

	public List<Movies> getAllMovies();	
}
