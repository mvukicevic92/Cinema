package Project.Cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public Page<Movie> findAll(Integer pageNo) {
		return movieRepository.findAll(PageRequest.of(pageNo, 5));
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

}
