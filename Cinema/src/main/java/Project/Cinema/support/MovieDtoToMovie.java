package Project.Cinema.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Project.Cinema.model.Movie;
import Project.Cinema.service.MovieService;
import Project.Cinema.web.dto.MovieDTO;

@Component
public class MovieDtoToMovie implements Converter<MovieDTO, Movie>{
	
	@Autowired
	private MovieService movieService;

	@Override
	public Movie convert(MovieDTO movieDto) {
		Movie movie = new Movie();
		if(movieDto.getId() == null) {
			movie = new Movie();
		}else {
			movie = movieService.findOne(movieDto.getId());
		}
		if(movie != null) {
			movie.setName(movieDto.getName());
			movie.setDirector(movieDto.getDirector());
			movie.setActors(movieDto.getActors());
			movie.setGenres(movieDto.getGenres());
			movie.setDuration(movieDto.getDuration());
			movie.setDistributor(movieDto.getDistributor());
			movie.setCountryOfOrigin(movieDto.getCountryOfOrigin());
			movie.setYearOfProduction(movieDto.getYearOfProduction());
			movie.setDescription(movieDto.getDescription());
		}
		return movie;
	}

}
