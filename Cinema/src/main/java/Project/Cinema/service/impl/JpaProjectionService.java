package Project.Cinema.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Project.Cinema.model.Projection;
import Project.Cinema.model.Seat;
import Project.Cinema.model.Ticket;
import Project.Cinema.repository.ProjectionRepository;
import Project.Cinema.repository.TicketRepository;
import Project.Cinema.service.ProjectionService;

@Service
public class JpaProjectionService implements ProjectionService{
	
	@Autowired
	private ProjectionRepository projectionRepository;
	
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public Projection findOne(Long id) {
		return projectionRepository.findOneById(id);
	}

	@Override
	public List<Projection> findAll() {
		return projectionRepository.findAll();
	}

	@Override
	public Page<Projection> findAll(Integer pageNo) {
		return projectionRepository.findAll(PageRequest.of(pageNo, 10));
	}

	@Override
	public Projection save(Projection projection) {
		return projectionRepository.save(projection);
	}

	@Override
	public Projection update(Projection projection) {
		return projectionRepository.save(projection);
	}

	@Override
	public Projection delete(Long id) {
		Projection projection = findOne(id);
		if(projection != null) {
			projection.getMovie().getProjections().remove(projection);
			projection.setMovie(null);
			projection.getHall().getProjections().remove(projection);
			projection.setHall(null);	
			projection = projectionRepository.save(projection);
			projectionRepository.delete(projection);
			return projection;
		}
		return null;
	}

	@Override
	public List<Projection> findByMovieId(Long movieId) {
		return projectionRepository.findByMovieId(movieId);
	}

	@Override
	public Ticket buyTicket(Long projectionId) {
		Projection projection = projectionRepository.findOneById(projectionId);
			if(projection.getDateTimeOfDisplay().isBefore(LocalDateTime.now()) ) {    
				Seat seat = new Seat(projection.getHall());
				
				Ticket newTicket = new Ticket(projection, seat, LocalDateTime.now());
				
				return ticketRepository.save(newTicket);
			}else {
				return null;
			}
	}

	@Override
	public List<Projection> findByDateTimeOfDisplayBetween(LocalDateTime dateFrom, LocalDateTime dateTo) {
		return projectionRepository.findByDateTimeOfDisplayBetween(dateFrom, dateTo);
	}

	@Override
	public Projection findOneByMovieId(Long movieId) {
		return projectionRepository.findOneByMovieId(movieId);
	}

}
