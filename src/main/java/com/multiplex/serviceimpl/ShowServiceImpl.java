package com.multiplex.serviceimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.multiplex.dao.ShowsRepository;
import com.multiplex.entity.Shows;
import com.multiplex.exception.ShowException;
import com.multiplex.service.ShowService;

@Service
public class ShowServiceImpl implements ShowService {
	@Autowired
	ShowsRepository showsrepositary;

	@Override
	public String addShow(Shows show) {
		showsrepositary.save(show);
		return "Show added successfully";
	}

	@Override
	public Shows getShowId(Integer showId) {
		return showsrepositary.findById(showId).orElseThrow(ShowException::new);
	}

	@Override
	public List<Shows> getAllShows() {
		List<Shows> shows = (List<Shows>) showsrepositary.findAll();
		return shows;
		}

	@Override
	public String deleteShow(Integer showId) {
		showsrepositary.deleteById(showId);
		return "Show deleted";
	}
}