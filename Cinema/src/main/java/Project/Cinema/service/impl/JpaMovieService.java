package Project.Cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Project.Cinema.model.Movie;
import Project.Cinema.repository.MovieRepository;
import Project.Cinema.service.MovieService;

@Service
public class JpaMovieService implements MovieService{
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie findOne(Long id) {
		return movieRepository.findOneById(id);
	}

	@Override
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	@Override
	public Page<Movie> findAll(Pageable pageable) {
		return movieRepository.findAll(PageRequest.of(0, 5, Sort.by("name").ascending().and(Sort.by("name").descending())));
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
				name, genres, durationFrom, durationTo, distributor, countryOfOrigin, yearOfProductionFrom, yearOfProductionTo, PageRequest.of(pageNo, 5));
	}

	@Override
	public Movie buyTicket(Long id) {
//		Movie movie = movieRepository.findOneById(id);
//		Ticket ticket = new Ticket();
//		ticket.setDateTimeOfPurchase(LocalDateTime.now());
//		Projection projection = projectionRepository.findOne(movie.getProjections());
//		if(projection.getDateTimeOfDisplay().isAfter(LocalDateTime.now())) {
//			
//		}
		return null;
	}

}
