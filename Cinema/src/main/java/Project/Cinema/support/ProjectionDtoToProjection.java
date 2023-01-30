package Project.Cinema.support;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Project.Cinema.model.Projection;
import Project.Cinema.service.HallService;
import Project.Cinema.service.MovieService;
import Project.Cinema.service.ProjectionService;
import Project.Cinema.web.dto.ProjectionDTO;

@Component
public class ProjectionDtoToProjection implements Converter<ProjectionDTO, Projection>{
	
	@Autowired
	private ProjectionService projectionService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private HallService hallService;

	@Override
	public Projection convert(ProjectionDTO projectionDto) {
		Projection projection = new Projection();
		if(projectionDto.getId() == null) {
			projection = new Projection();
		}else {
			projection = projectionService.findOne(projectionDto.getId());
		}
		if(projection != null) {
			projection.setMovie(movieService.findOne(projectionDto.getMovie().getId()));
			projection.setHall(hallService.findOne(projectionDto.getHall().getId()));
			projection.setDateTimeOfDisplay(getLocalDateTime(projectionDto.getDateTimeOfDisplay()));
			projection.setTicketPrice(projectionDto.getTicketPrice());
		}
		return projection;
	}
	
    private LocalDateTime getLocalDateTime(String dateTime) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDateTime.parse(dateTime, formatter);
    }

}
