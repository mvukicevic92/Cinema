package Project.Cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Project.Cinema.model.TypeOfProjection;

@Repository
public interface TypeOfProjectionRepository extends JpaRepository<TypeOfProjection, Long>{
	
	TypeOfProjection findOneById(Long id);

}
