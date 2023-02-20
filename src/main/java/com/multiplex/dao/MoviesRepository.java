package com.multiplex.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.multiplex.entity.Movies;

public interface MoviesRepository extends JpaRepository<Movies, Integer> {

}