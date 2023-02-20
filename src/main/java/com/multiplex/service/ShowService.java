package com.multiplex.service;
import java.util.List;
import com.multiplex.entity.Shows;

public interface ShowService {
	public String addShow(Shows show);
	public Shows getShowId(Integer showId);
	public List<Shows> getAllShows();
	public String deleteShow(Integer showId);
}