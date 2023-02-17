package Project.Cinema.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;

import Project.Cinema.model.Movie;
import Project.Cinema.model.Ticket;

public interface MovieService {

	Movie findOne(Long id);
	List<Movie> findAll();
	Page<Movie> findAll(Integer pageNo);
	Movie save(Movie movie);
	Movie update(Movie movie);
	Movie delete(Long id);
	Page<Movie> search(String name, String genres, Integer durationFrom, Integer durationTo, String distributor, String countryOfOrigin, Integer yearOfProductionFrom, Integer yearOfProductionTo, Integer pageNo);
	Ticket buyTicket(Long movieId, Long projectionId, Integer seatNumber);
	List<Movie> report(LocalDateTime dateFrom, LocalDateTime dateTo);
	List<Movie> findByProjectionsId(Long projectionId);
}
