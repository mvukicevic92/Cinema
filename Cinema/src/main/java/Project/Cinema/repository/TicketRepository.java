package Project.Cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Project.Cinema.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
	
	Ticket findOneById(Long id);
	List<Ticket> findByProjectionId(Long projectionId);
	Ticket findOneByProjectionId(Long projectionId);
	
}
