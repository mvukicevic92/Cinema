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

import Project.Cinema.model.Seat;
import Project.Cinema.service.SeatService;
import Project.Cinema.support.SeatToSeatDto;
import Project.Cinema.web.dto.SeatDTO;

@RestController
@RequestMapping(value = "/api/seats", produces = MediaType.APPLICATION_JSON_VALUE)
public class SeatController {
	
	@Autowired
	private SeatService seatService;
	
	@Autowired
	private SeatToSeatDto toSeatDto;
	
	@GetMapping
	public ResponseEntity<List<SeatDTO>> getAll(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo){
		Page<Seat> page;
		page = seatService.findAll(pageNo);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
		
		return new ResponseEntity<>(toSeatDto.convert(page.getContent()), HttpStatus.OK);
	}

}
