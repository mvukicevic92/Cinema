package Project.Cinema.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Project.Cinema.model.Movie;
import Project.Cinema.service.MovieService;
import Project.Cinema.support.MovieDtoToMovie;
import Project.Cinema.support.MovieToMovieDto;
import Project.Cinema.web.dto.MovieDTO;

@RestController
@RequestMapping(value = "/api/movies", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private MovieToMovieDto toMovieDto;
	
	@Autowired
	private MovieDtoToMovie toMovie;
	
	@PreAuthorize("permitAll()")
	@GetMapping
	public ResponseEntity<List<MovieDTO>> getAll(@RequestParam(required = false) String name,
												@RequestParam(required = false) String genres,
												@RequestParam(required = false) Integer durationFrom,
												@RequestParam(required = false) Integer durationTo,
												@RequestParam(required = false) String distributor,
												@RequestParam(required = false) String countryOfOrigin,
												@RequestParam(required = false) Integer yearOfProductionFrom,
												@RequestParam(required = false)	Integer yearOfProductionTo,
												@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo){
		Page<Movie> page;
		try {
			page = movieService.search(name, genres, durationFrom, durationTo, distributor, countryOfOrigin, yearOfProductionFrom, yearOfProductionTo, pageNo);
		} catch (Exception e) {
			Pageable pageable = PageRequest.of(pageNo, 5, Sort.by(name));
			page = movieService.findAll(pageable);
		}
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
		
		return new ResponseEntity<>(toMovieDto.convert(page.getContent()), headers, HttpStatus.OK);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MovieDTO> create(@Valid @RequestBody MovieDTO movieDto){
		Movie movie = toMovie.convert(movieDto);
		Movie savedMovie = movieService.save(movie);
		
		return new ResponseEntity<>(toMovieDto.convert(savedMovie), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDTO> getOne(@PathVariable Long id){
		Movie movie = movieService.findOne(id);
		if(movie != null) {
			return new ResponseEntity<>(toMovieDto.convert(movie), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MovieDTO> update(@PathVariable Long id, @Valid @RequestBody MovieDTO movieDto){
		if(!id.equals(movieDto.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Movie movie = toMovie.convert(movieDto);
		Movie savedMovie = movieService.update(movie);
		
		return new ResponseEntity<>(toMovieDto.convert(savedMovie), HttpStatus.OK);
	}
	
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		Movie deletedMovie = movieService.delete(id);
		if(deletedMovie != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value = "/{id}/buyTicket", produces = MediaType.APPLICATION_JSON_VALUE) // proveriti putanju
	public ResponseEntity<MovieDTO> buyTicket(@PathVariable Long id){
		
		
		
		return null;
	}
	
}
