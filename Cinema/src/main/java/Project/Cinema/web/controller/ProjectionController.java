package Project.Cinema.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Project.Cinema.model.Projection;
import Project.Cinema.model.Ticket;
import Project.Cinema.service.ProjectionService;
import Project.Cinema.support.ProjectionToProjectionDto;
import Project.Cinema.support.TicketToTicketDto;
import Project.Cinema.web.dto.ProjectionDTO;
import Project.Cinema.web.dto.TicketDTO;

@RestController
@RequestMapping(value = "/api/projections", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectionController {
	
	@Autowired
	private ProjectionService projectionService;
	
	@Autowired
	private ProjectionToProjectionDto toProjectionDto;
	
	@Autowired
	private TicketToTicketDto toTicketDto;
	
	@GetMapping
	public ResponseEntity<List<ProjectionDTO>> getAll(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo){
		Page<Projection> page;
		page = projectionService.findAll(pageNo);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
		
		return new ResponseEntity<>(toProjectionDto.convert(page.getContent()), headers, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ProjectionDTO> delete (@PathVariable Long id){
		Projection deletedProjection = projectionService.delete(id);
		
		if(deletedProjection == null) {
			return new ResponseEntity<>(toProjectionDto.convert(deletedProjection) , HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value = "/{projectionId}/buyTicket", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TicketDTO> buyTicket(@PathVariable Long projectionId ){
		Ticket ticket = projectionService.buyTicket(projectionId);
		if(ticket != null) {
			return new ResponseEntity<>(toTicketDto.convert(ticket), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
