package Project.Cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Project.Cinema.model.Seat;
import Project.Cinema.web.dto.SeatDTO;

@Component
public class SeatToSeatDto implements Converter<Seat, SeatDTO>{
	
	@Autowired
	private HallToHallDto toHallDto;

	@Override
	public SeatDTO convert(Seat seat) {
		SeatDTO seatDto = new SeatDTO();
		seatDto.setSerialNumber(seat.getSerialNumber());
		seatDto.setHall(toHallDto.convert(seat.getHall()));
		return seatDto;
	}
	
	public List<SeatDTO> convert(List<Seat> seats){
		List<SeatDTO> seatsDto = new ArrayList<>();
		for(Seat seat : seats) {
			seatsDto.add(convert(seat));
		}
		return seatsDto;
	}

}
