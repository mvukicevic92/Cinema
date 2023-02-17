package Project.Cinema.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;

import Project.Cinema.model.Projection;
import Project.Cinema.model.Ticket;

public interface ProjectionService {
	
	Projection findOne(Long id);
	List<Projection> findAll();
	Page<Projection> findAll(Integer pageNo);
	Projection save(Projection projection);
	Projection update(Projection projection);
	Projection delete(Long id);
	List<Projection> findByMovieId(Long movieId);
	Projection findOneByMovieId(Long movieId);
	Ticket buyTicket(Long projectionId);
	List<Projection> findByDateTimeOfDisplayBetween(LocalDateTime dateFrom, LocalDateTime dateTo);
}
