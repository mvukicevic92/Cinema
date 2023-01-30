package Project.Cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Project.Cinema.model.TypeOfProjection;
import Project.Cinema.web.dto.TypeOfProjectionDTO;

@Component
public class TypeOfProjectionToTypeOfProjectionDto implements Converter<TypeOfProjection, TypeOfProjectionDTO>{

	@Override
	public TypeOfProjectionDTO convert(TypeOfProjection typeOfProjection) {
		TypeOfProjectionDTO typeOfProjectionDto = new TypeOfProjectionDTO();
		typeOfProjectionDto.setId(typeOfProjection.getId());
		typeOfProjectionDto.setName(typeOfProjection.getName());
		return typeOfProjectionDto;
	}
	
	public List<TypeOfProjectionDTO> convert(List<TypeOfProjection> typesOfProjection){
		List<TypeOfProjectionDTO> typesOfProjectionDto = new ArrayList<>();
		for(TypeOfProjection typeOfProjection : typesOfProjection) {
			typesOfProjectionDto.add(convert(typeOfProjection));
		}
		return typesOfProjectionDto;
	}
}
