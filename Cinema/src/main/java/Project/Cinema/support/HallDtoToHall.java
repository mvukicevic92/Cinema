package Project.Cinema.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Project.Cinema.model.Hall;
import Project.Cinema.service.HallService;
import Project.Cinema.web.dto.HallDTO;

@Component
public class HallDtoToHall implements Converter<HallDTO, Hall>{
	
	@Autowired
	private HallService hallService;

	@Override
	public Hall convert(HallDTO hallDto) {
		Hall hall = new Hall();
		if(hallDto.getId() == null) {
			hall = new Hall();
		}else {
			hall = hallService.findOne(hallDto.getId());
		}
		if(hall != null) {
			hall.setName(hallDto.getName());
		}
		return hall;
	}

}
