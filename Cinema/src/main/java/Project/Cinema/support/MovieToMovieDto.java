package Project.Cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Project.Cinema.model.Movie;
import Project.Cinema.web.dto.MovieDTO;

@Component
public class MovieToMovieDto implements Converter<Movie, MovieDTO>{

	@Override
	public MovieDTO convert(Movie movie) {
		MovieDTO movieDto = new MovieDTO();
		movieDto.setId(movie.getId());
		movieDto.setName(movie.getName());
		movieDto.setDirector(movie.getDirector());
		movieDto.setActors(movie.getActors());
		movieDto.setGenres(movie.getGenres());
		movieDto.setDuration(movie.getDuration());
		movieDto.setDistributor(movie.getDistributor());
		movieDto.setCountryOfOrigin(movie.getCountryOfOrigin());
		movieDto.setYearOfProduction(movie.getYearOfProduction());
		movieDto.setDescription(movie.getDescription());
		return movieDto;
	}
	
	public List<MovieDTO> convert(List<Movie> movies){
		List<MovieDTO> moviesDto = new ArrayList<>();
		for(Movie movie : movies) {
			moviesDto.add(convert(movie));
		}
		return moviesDto;
	}

}
