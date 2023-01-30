package Project.Cinema.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Project.Cinema.model.Movie;
import Project.Cinema.service.MovieService;
import Project.Cinema.support.MovieToMovieDto;
import Project.Cinema.web.dto.MovieDTO;

@RestController
@RequestMapping(value = "/api/movies", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private MovieToMovieDto toMovieDto;
	
	@GetMapping
	public ResponseEntity<List<MovieDTO>> getAll(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo){
		Page<Movie> page;
		page = movieService.findAll(pageNo);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
		
		return new ResponseEntity<>(toMovieDto.convert(page.getContent()), headers, HttpStatus.OK);
	}

}
