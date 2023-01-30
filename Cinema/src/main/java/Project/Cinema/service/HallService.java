package Project.Cinema.service;

import java.util.List;

import org.springframework.data.domain.Page;

import Project.Cinema.model.Hall;

public interface HallService {
	
	Hall findOne(Long id);
	List<Hall> findAll();
	Page<Hall> findAll(Integer pageNo);
	Hall save(Hall hall);
	Hall update(Hall hall);
	Hall delete(Long id);

}
