package Project.Cinema.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Project.Cinema.model.TypeOfProjection;
import Project.Cinema.service.TypeOfProjectionService;
import Project.Cinema.web.dto.TypeOfProjectionDTO;

@Component
public class TypeOfProjectionDtoToTypeOfProjection implements Converter<TypeOfProjectionDTO, TypeOfProjection>{
	
	@Autowired
	private TypeOfProjectionService typeOfProjectionService;

	@Override
	public TypeOfProjection convert(TypeOfProjectionDTO typeOfProjectionDto) {
		TypeOfProjection typeOfProjection = new TypeOfProjection();
		if(typeOfProjectionDto.getId() == null) {
			typeOfProjection = new TypeOfProjection();
		}else {
			typeOfProjection = typeOfProjectionService.findOne(typeOfProjectionDto.getId());
		}
		if(typeOfProjection != null) {
			typeOfProjection.setName(typeOfProjectionDto.getName());
		}
		return typeOfProjection;
	}

}
