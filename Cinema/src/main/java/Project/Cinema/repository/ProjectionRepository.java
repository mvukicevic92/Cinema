package Project.Cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Project.Cinema.model.Projection;

@Repository
public interface ProjectionRepository extends JpaRepository<Projection, Long>{
	
	Projection findOneById(Long id);
	List<Projection> findByMovieId(Long movieId);

}
