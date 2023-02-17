package Project.Cinema.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Project.Cinema.model.Projection;

@Repository
public interface ProjectionRepository extends JpaRepository<Projection, Long>{
	
	Projection findOneById(Long id);
	Projection findOneByMovieId(Long movieId);
	List<Projection> findByMovieId(Long movieId);
	List<Projection> findByDateTimeOfDisplayBetween(LocalDateTime dateFrom, LocalDateTime dateTo);

}
