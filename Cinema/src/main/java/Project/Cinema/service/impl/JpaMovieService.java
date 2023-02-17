package Project.Cinema.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Project.Cinema.model.Movie;
import Project.Cinema.model.Projection;
import Project.Cinema.model.Seat;
import Project.Cinema.model.Ticket;
import Project.Cinema.repository.MovieRepository;
import Project.Cinema.repository.ProjectionRepository;
import Project.Cinema.repository.SeatRepository;
import Project.Cinema.repository.TicketRepository;
import Project.Cinema.service.MovieService;

@Service
public class JpaMovieService implements MovieService{
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ProjectionRepository projectionRepository;
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private SeatRepository seatRepository;
	
	@Override
	public Movie findOne(Long id) {
		return movieRepository.findOneById(id);
	}
	
	@Override
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}
	
	@Override
	public Page<Movie> findAll(Integer pageNo) {
		return movieRepository.findAll(PageRequest.of(pageNo, 10));
	}
	
	@Override
	public Movie save(Movie movie) {
		return movieRepository.save(movie);
	}
	
	@Override
	public Movie update(Movie movie) {
		return movieRepository.save(movie);
	}
	
	@Override
	public Movie delete(Long id) {
		Optional<Movie> movie = movieRepository.findById(id);
		if(movie.isPresent()) {
			movieRepository.deleteById(id);
			return movie.get();
		}
		return null;
	}
	
	@Override
	public Page<Movie> search(String name, String genres, Integer durationFrom, Integer durationTo, String distributor,
			String countryOfOrigin, Integer yearOfProductionFrom, Integer yearOfProductionTo, Integer pageNo) {
		if(name == null) {
			name = "";
		}
		if(genres == null) {
			genres = "";
		}
		if(durationFrom == null) {
			durationFrom = 0;
		}
		if(durationTo == null) {
			durationTo = Integer.MAX_VALUE;
		}
		if(distributor == null) {
			distributor = "";
		}
		if(countryOfOrigin == null) {
			countryOfOrigin = "";
		}
		if(yearOfProductionFrom == null) {
			yearOfProductionFrom = 0;
		}
		if(yearOfProductionTo == null) {
			yearOfProductionTo = Integer.MAX_VALUE;
		}
		
		return movieRepository.findByNameIgnoreCaseContainsAndGenresIgnoreCaseContainsAndDurationBetweenAndDistributorIgnoreCaseContainsAndCountryOfOriginIgnoreCaseContainsAndYearOfProductionBetween(
				name, genres, durationFrom, durationTo, distributor, countryOfOrigin, yearOfProductionFrom, yearOfProductionTo, PageRequest.of(pageNo, 10));
	}
	
	@Override
	public Ticket buyTicket(Long movieId, Long projectionId, Integer seatNumber) {
		Movie movie = movieRepository.findOneById(movieId);
		
		Projection projection = projectionRepository.findOneById(projectionId);
		projection.setMovie(movie);
		
		Ticket ticket = ticketRepository.findOneByProjectionId(projection.getId());
			if(projection.getDateTimeOfDisplay().isBefore(LocalDateTime.now()) && ticket.getSeat().getSerialNumber() != seatNumber) {    // && !projection.getHall().getSeats().equals(seat)
				Seat seat = seatRepository.findOneBySerialNumber(seatNumber);
				
				Ticket newTicket = new Ticket();
				
				newTicket = new Ticket(projection, seat, LocalDateTime.now());
				
				return ticketRepository.save(newTicket);
			}else {
				Ticket ticketNull = null;
				return ticketNull;
			}
	}
    
	@Override // ovo sve mozda u reportService i reportController
	public List<Movie> report(LocalDateTime dateFrom, LocalDateTime dateTo) {
		
		List<Projection> projections = projectionRepository.findByDateTimeOfDisplayBetween(dateFrom, dateTo);
		for (Projection projection : projections) {
			List<Movie> movies = movieRepository.findByProjectionsId(projection.getId());
			return movies;
		}
		return null;
	}
	
	@Override
	public List<Movie> findByProjectionsId(Long projectionId) {
		return movieRepository.findByProjectionsId(projectionId);
	}

}
