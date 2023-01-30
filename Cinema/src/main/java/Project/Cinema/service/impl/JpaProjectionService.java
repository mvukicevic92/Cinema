package Project.Cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Project.Cinema.model.Projection;
import Project.Cinema.repository.ProjectionRepository;
import Project.Cinema.service.ProjectionService;

@Service
public class JpaProjectionService implements ProjectionService{
	
	@Autowired
	private ProjectionRepository projectionRepository;

	@Override
	public Projection findOne(Long id) {
		return projectionRepository.findOneById(id);
	}

	@Override
	public List<Projection> findAll() {
		return projectionRepository.findAll();
	}

	@Override
	public Page<Projection> findAll(Integer pageNo) {
		return projectionRepository.findAll(PageRequest.of(pageNo, 5));
	}

	@Override
	public Projection save(Projection projection) {
		return projectionRepository.save(projection);
	}

	@Override
	public Projection update(Projection projection) {
		return projectionRepository.save(projection);
	}

	@Override
	public Projection delete(Long id) {
		Optional<Projection> projection = projectionRepository.findById(id);
		if(projection.isPresent()) {
			projectionRepository.deleteById(id);
			return projection.get();
		}
		return null;
	}

}
