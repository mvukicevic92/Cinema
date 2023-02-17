package Project.Cinema.web.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Project.Cinema.model.Movie;
import Project.Cinema.model.Projection;
import Project.Cinema.model.Ticket;
import Project.Cinema.service.MovieService;
import Project.Cinema.service.ProjectionService;
import Project.Cinema.service.TicketService;
import Project.Cinema.web.dto.ReportDTO;

@RestController
@RequestMapping(value = "/api/report", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private ProjectionService projectionService;
	
	@Autowired
	private TicketService ticketService;
	
	@GetMapping
	public ResponseEntity<List<ReportDTO>> getReport(@RequestParam(required = true) String dateFrom,
													@RequestParam(required = true) String dateTo,
													@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo){
		
		List<ReportDTO> reports = new ArrayList<>();
			
		LocalDateTime dateFromLD = getLocalDateTime(dateFrom);
		LocalDateTime dateToLD = getLocalDateTime(dateTo);
		
		List<Movie> movies = movieService.findAll();
		for (Movie movie : movies) {
			List<Projection> projections = projectionService.findByMovieId(movie.getId());

			for (Projection projection : projections) {
				if(projection.getDateTimeOfDisplay().isAfter(dateFromLD) && projection.getDateTimeOfDisplay().isBefore(dateToLD)) {
					
					List<Ticket> tickets = ticketService.findByProjectionId(projection.getId());
					
					ReportDTO report = new ReportDTO();
					
					report.setMovieName(movie.getName());
					report.setNumOfProjections(movie.getProjections().size());
					report.setNumOfTicketsSold(tickets.size());
					Double sum = ticketService.sum(projection.getTicketPrice(), tickets.size());
					report.setSum(sum);
					reports.add(report);	
				}
			}
		}
		
		return new ResponseEntity<>(reports, HttpStatus.OK);
	}
	
    private LocalDateTime getLocalDateTime(String date) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(date, formatter);
    }
    
    
}
