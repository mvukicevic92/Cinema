package Project.Cinema.service;

import java.util.List;

import org.springframework.data.domain.Page;

import Project.Cinema.model.Ticket;

public interface TicketService {
	
	Ticket findOne(Long id);
	List<Ticket> findAll();
	Page<Ticket> findAll(Integer pageNo);
	Ticket save(Ticket ticket);
	Ticket update(Ticket ticket);
	Ticket delete(Long id);

}
