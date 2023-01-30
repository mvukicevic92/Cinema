package Project.Cinema.service;

import java.util.List;

import org.springframework.data.domain.Page;

import Project.Cinema.model.Seat;

public interface SeatService {
	
	Seat findOne(Integer serialNumber);
	List<Seat> findAll();
	Page<Seat> findAll(Integer pageNo);
	Seat save(Seat seat);
	Seat update(Seat seat);
	Seat delete(Integer serialNumber);

}
