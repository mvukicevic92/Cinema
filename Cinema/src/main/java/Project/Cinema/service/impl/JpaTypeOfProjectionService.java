package Project.Cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Project.Cinema.model.TypeOfProjection;
import Project.Cinema.repository.TypeOfProjectionRepository;
import Project.Cinema.service.TypeOfProjectionService;

@Service
public class JpaTypeOfProjectionService implements TypeOfProjectionService{
	
	@Autowired
	private TypeOfProjectionRepository typeOfProjectionRepository;

	@Override
	public TypeOfProjection findOne(Long id) {
		return typeOfProjectionRepository.findOneById(id);
	}

	@Override
	public List<TypeOfProjection> findAll() {
		return typeOfProjectionRepository.findAll();
	}

	@Override
	public Page<TypeOfProjection> findAll(Integer pageNo) {
		return typeOfProjectionRepository.findAll(PageRequest.of(pageNo, 3));
	}

	@Override
	public TypeOfProjection save(TypeOfProjection typeOfProjection) {
		return typeOfProjectionRepository.save(typeOfProjection);
	}

	@Override
	public TypeOfProjection update(TypeOfProjection typeOfProjection) {
		return typeOfProjectionRepository.save(typeOfProjection);
	}

	@Override
	public TypeOfProjection delete(Long id) {
		Optional<TypeOfProjection> typeOfProjection = typeOfProjectionRepository.findById(id);
		if(typeOfProjection.isPresent()) {
			typeOfProjectionRepository.deleteById(id);
			return typeOfProjection.get();
		}
		return null;
	}

}
