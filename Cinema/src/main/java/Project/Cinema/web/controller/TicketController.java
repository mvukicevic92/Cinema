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

import Project.Cinema.model.Ticket;
import Project.Cinema.service.TicketService;
import Project.Cinema.support.TicketToTicketDto;
import Project.Cinema.web.dto.TicketDTO;

@RestController
@RequestMapping(value = "/api/tickets", produces = MediaType.APPLICATION_JSON_VALUE)
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private TicketToTicketDto toTicketDto;
	
	@GetMapping
	public ResponseEntity<List<TicketDTO>> getAll(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo){
		Page<Ticket> page;
		page = ticketService.findAll(pageNo);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
		
		return new ResponseEntity<>(toTicketDto.convert(page.getContent()), headers, HttpStatus.OK);
	}

}
