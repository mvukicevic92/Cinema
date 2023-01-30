package Project.Cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Project.Cinema.model.Hall;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long>{
	
	Hall findOneById(Long id);

}
