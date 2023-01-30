package Project.Cinema.service;

import java.util.List;

import org.springframework.data.domain.Page;

import Project.Cinema.model.Projection;

public interface ProjectionService {
	
	Projection findOne(Long id);
	List<Projection> findAll();
	Page<Projection> findAll(Integer pageNo);
	Projection save(Projection projection);
	Projection update(Projection projection);
	Projection delete(Long id);

}
