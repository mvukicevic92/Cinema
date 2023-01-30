package Project.Cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Project.Cinema.model.Ticket;
import Project.Cinema.repository.TicketRepository;
import Project.Cinema.service.TicketService;

@Service
public class JpaTicketService implements TicketService{
	
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public Ticket findOne(Long id) {
		return ticketRepository.findOneById(id);
	}

	@Override
	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}

	@Override
	public Page<Ticket> findAll(Integer pageNo) {
		return ticketRepository.findAll(PageRequest.of(pageNo, 5));
	}

	@Override
	public Ticket save(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket update(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket delete(Long id) {
		Optional<Ticket> ticket = ticketRepository.findById(id);
		if(ticket.isPresent()) {
			ticketRepository.deleteById(id);
			return ticket.get();
		}
		return null;
	}

}
