package Project.Cinema.service;

import java.util.List;

import org.springframework.data.domain.Page;

import Project.Cinema.model.Movie;

public interface MovieService {

	Movie findOne(Long id);
	List<Movie> findAll();
	Page<Movie> findAll(Integer pageNo);
	Movie save(Movie movie);
	Movie update(Movie movie);
	Movie delete(Long id);
	Page<Movie> search(String name, String genres, Integer durationFrom, Integer durationTo, String distributor, String countryOfOrigin, Integer yearOfProductionFrom, Integer yearOfProductionTo, Integer pageNo);
}
