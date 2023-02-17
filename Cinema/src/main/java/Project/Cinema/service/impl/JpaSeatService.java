package Project.Cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Project.Cinema.model.Seat;
import Project.Cinema.repository.SeatRepository;
import Project.Cinema.service.SeatService;

@Service
public class JpaSeatService implements SeatService{
	
	@Autowired
	private SeatRepository seatRepository;

	@Override
	public Seat findOne(Integer serialNumber) {
		return seatRepository.findOneBySerialNumber(serialNumber);
	}

	@Override
	public List<Seat> findAll() {
		return seatRepository.findAll();
	}

	@Override
	public Page<Seat> findAll(Integer pageNo) {
		return seatRepository.findAll(PageRequest.of(pageNo, 10));
	}

	@Override
	public Seat save(Seat seat) {
		return seatRepository.save(seat);
	}

	@Override
	public Seat update(Seat seat) {
		return seatRepository.save(seat);
	}

	@Override
	public Seat delete(Integer serialNumber) {
		Optional<Seat> seat = seatRepository.findById(serialNumber);
		if(seat.isPresent()) {
			seatRepository.deleteById(serialNumber);
			return seat.get();
		}
		
		return null;
	}

}
