package Project.Cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Project.Cinema.model.Ticket;
import Project.Cinema.web.dto.TicketDTO;

@Component
public class TicketToTicketDto implements Converter<Ticket, TicketDTO>{
	
	@Autowired
	private ProjectionToProjectionDto toProjectionDto;
	
	@Autowired
	private SeatToSeatDto toSeatDto;

	@Override
	public TicketDTO convert(Ticket ticket) {
		TicketDTO ticketDto = new TicketDTO();
		ticketDto.setId(ticket.getId());
		ticketDto.setProjection(toProjectionDto.convert(ticket.getProjection()));
		ticketDto.setSeat(toSeatDto.convert(ticket.getSeat()));
		ticketDto.setDateTimeOfPurchase(ticket.getDateTimeOfPurchase().toString());
		return ticketDto;
	}
	
	public List<TicketDTO> convert(List<Ticket> tickets){
		List<TicketDTO> ticketsDto = new ArrayList<>();
		for(Ticket ticket : tickets) {
			ticketsDto.add(convert(ticket));
		}
		return ticketsDto;
	}

}
