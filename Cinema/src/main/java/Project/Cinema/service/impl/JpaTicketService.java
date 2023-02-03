package Project.Cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Project.Cinema.model.Projection;
import Project.Cinema.model.Ticket;
import Project.Cinema.repository.ProjectionRepository;
import Project.Cinema.repository.TicketRepository;
import Project.Cinema.service.TicketService;

@Service
public class JpaTicketService implements TicketService{
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private ProjectionRepository projectionRepository;

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
		Ticket ticket = ticketRepository.findOneById(id);
		if(ticket != null) {
			Projection projection = ticket.getProjection();
			projectionRepository.delete(projection);	
			ticketRepository.save(ticket);
			ticketRepository.deleteById(id);
			return ticket;
		}
		return null;
	}

	@Override
	public List<Ticket> findByProjectionId(Long projectionId) {
		return ticketRepository.findByProjectionId(projectionId);
	}

}
