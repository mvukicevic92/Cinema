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

import Project.Cinema.model.Hall;
import Project.Cinema.service.HallService;
import Project.Cinema.support.HallToHallDto;
import Project.Cinema.web.dto.HallDTO;

@RestController
@RequestMapping(value = "/api/halls", produces = MediaType.APPLICATION_JSON_VALUE)
public class HallController {
	
	@Autowired
	private HallService hallService;
	
	@Autowired
	private HallToHallDto toHallDto;
	
	@GetMapping
	public ResponseEntity<List<HallDTO>> getAll(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo){
		Page<Hall> page;
		page = hallService.findAll(pageNo);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
		
		return new ResponseEntity<>(toHallDto.convert(page.getContent()), headers, HttpStatus.OK);
	}

}
