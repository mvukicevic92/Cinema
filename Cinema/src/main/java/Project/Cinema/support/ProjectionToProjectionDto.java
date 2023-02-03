package Project.Cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Project.Cinema.model.Projection;
import Project.Cinema.web.dto.ProjectionDTO;

@Component
public class ProjectionToProjectionDto implements Converter<Projection, ProjectionDTO>{
	
	@Autowired
	private MovieToMovieDto toMovieDto;
	
	@Autowired
	private HallToHallDto toHallDto;
	
	@Autowired
	private TypeOfProjectionToTypeOfProjectionDto toTypeOfProjectionDto;

	@Override
	public ProjectionDTO convert(Projection projection) {
		ProjectionDTO projectionDto = new ProjectionDTO();
		projectionDto.setId(projection.getId());
		projectionDto.setMovie(toMovieDto.convert(projection.getMovie()));
		projectionDto.setTypeOfProjection(toTypeOfProjectionDto.convert(projection.getTypeOfProjection()));
		projectionDto.setHall(toHallDto.convert(projection.getHall()));
		projectionDto.setDateTimeOfDisplay(projection.getDateTimeOfDisplay().toString());
		projectionDto.setTicketPrice(projection.getTicketPrice());
		return projectionDto;
	}
	
	public List<ProjectionDTO> convert(List<Projection> projections){
		List<ProjectionDTO> projectionsDto = new ArrayList<>();
		for(Projection projection : projections) {
			projectionsDto.add(convert(projection));
		}
		return projectionsDto;
	}

}
