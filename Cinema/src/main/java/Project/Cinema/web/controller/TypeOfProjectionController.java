package Project.Cinema.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Project.Cinema.model.TypeOfProjection;
import Project.Cinema.service.TypeOfProjectionService;
import Project.Cinema.support.TypeOfProjectionToTypeOfProjectionDto;
import Project.Cinema.web.dto.TypeOfProjectionDTO;

@RestController
@RequestMapping(value = "/api/typesOfProjections", produces = MediaType.APPLICATION_JSON_VALUE)
public class TypeOfProjectionController {
	
	@Autowired
	private TypeOfProjectionService typeOfProjectionService;
	
	@Autowired
	private TypeOfProjectionToTypeOfProjectionDto toTypeOfProjectionDto;
	
	@GetMapping
	public ResponseEntity<List<TypeOfProjectionDTO>> getAll(){
		List<TypeOfProjection> typesOfProjection = typeOfProjectionService.findAll();
		if(typesOfProjection != null) {
			return new ResponseEntity<>(toTypeOfProjectionDto.convert(typesOfProjection), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
