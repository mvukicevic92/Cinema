package Project.Cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Project.Cinema.model.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer>{
	
	Seat findOneBySerialNumber(Integer serialNumber);

}
