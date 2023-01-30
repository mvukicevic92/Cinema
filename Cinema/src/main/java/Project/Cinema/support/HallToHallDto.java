package Project.Cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Project.Cinema.model.Hall;
import Project.Cinema.web.dto.HallDTO;

@Component
public class HallToHallDto implements Converter<Hall, HallDTO>{

	@Override
	public HallDTO convert(Hall hall) {
		HallDTO hallDto = new HallDTO();
		hallDto.setId(hall.getId());
		hallDto.setName(hall.getName());
		return hallDto;
	}
	
	public List<HallDTO> convert(List<Hall> halls){
		List<HallDTO> hallsDto = new ArrayList<>();
		for(Hall hall : halls) {
			hallsDto.add(convert(hall));
		}
		return hallsDto;
	}

}
