package Project.Cinema.support;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Project.Cinema.model.Ticket;
import Project.Cinema.service.ProjectionService;
import Project.Cinema.service.SeatService;
import Project.Cinema.service.TicketService;
import Project.Cinema.web.dto.TicketDTO;

@Component
public class TicketDtoToTicket implements Converter<TicketDTO, Ticket>{
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private ProjectionService projectionService;
	
	@Autowired
	private SeatService seatService;

	@Override
	public Ticket convert(TicketDTO ticketDto) {
		Ticket ticket = new Ticket();
		if(ticketDto.getId() == null) {
			ticket = new Ticket();
		}else {
			ticket = ticketService.findOne(ticketDto.getId());
		}
		if(ticket != null) {
			ticket.setProjection(projectionService.findOne(ticketDto.getProjection().getId()));
			ticket.setSeat(seatService.findOne(ticketDto.getSeat().getSerialNumber()));
			ticket.setDateTimeOfPurchase(getLocalDateTime(ticketDto.getDateTimeOfPurchase()));
			
		}
		return ticket;
	}
	
    private LocalDateTime getLocalDateTime(String dateTime) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // dodao HH:mm:ss
        return LocalDateTime.parse(dateTime, formatter);
    }

}
