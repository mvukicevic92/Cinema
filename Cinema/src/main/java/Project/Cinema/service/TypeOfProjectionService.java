package Project.Cinema.service;

import java.util.List;

import org.springframework.data.domain.Page;

import Project.Cinema.model.TypeOfProjection;

public interface TypeOfProjectionService {
	
	TypeOfProjection findOne(Long id);
	List<TypeOfProjection> findAll();
	Page<TypeOfProjection> findAll(Integer pageNo);
	TypeOfProjection save(TypeOfProjection typeOfProjection);
	TypeOfProjection update(TypeOfProjection typeOfProjection);
	TypeOfProjection delete(Long id);
}
