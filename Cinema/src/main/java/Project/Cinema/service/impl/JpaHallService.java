package Project.Cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Project.Cinema.model.Hall;
import Project.Cinema.repository.HallRepository;
import Project.Cinema.service.HallService;

@Service
public class JpaHallService implements HallService{
	
	@Autowired
	private HallRepository hallRepository;

	@Override
	public Hall findOne(Long id) {
		return hallRepository.findOneById(id);
	}

	@Override
	public List<Hall> findAll() {
		return hallRepository.findAll();
	}

	@Override
	public Page<Hall> findAll(Integer pageNo) {
		return hallRepository.findAll(PageRequest.of(pageNo, 5));
	}

	@Override
	public Hall save(Hall hall) {
		return hallRepository.save(hall);
	}

	@Override
	public Hall update(Hall hall) {
		return hallRepository.save(hall);
	}

	@Override
	public Hall delete(Long id) {
		Optional<Hall> hall = hallRepository.findById(id);
		if(hall.isPresent()) {
			hallRepository.deleteById(id);
			return hall.get();
		}
		return null;
	}

}
