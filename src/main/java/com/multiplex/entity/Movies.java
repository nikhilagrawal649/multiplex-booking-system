package com.multiplex.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Movie_Master")
public class Movies{
	@Id
     private Integer movieId;
    private  String movieName;
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	@OneToMany(mappedBy = "movie", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Shows> shows;
     
}
