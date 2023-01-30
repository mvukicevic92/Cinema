package Project.Cinema.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Project.Cinema.model.Seat;
import Project.Cinema.service.HallService;
import Project.Cinema.service.SeatService;
import Project.Cinema.web.dto.SeatDTO;

@Component
public class SeatDtoToSeat implements Converter<SeatDTO, Seat>{
	
	@Autowired
	private SeatService seatService;
	
	@Autowired
	private HallService hallService;

	@Override
	public Seat convert(SeatDTO seatDto) {
		Seat seat = new Seat();
		if(seatDto.getSerialNumber() == null) {
			seat = new Seat();
		}else {
			seat = seatService.findOne(seatDto.getSerialNumber());
		}
		if(seat != null) {
			seat.setHall(hallService.findOne(seatDto.getHall().getId()));
		}
		return seat;
	}
	

}
