package Project.Cinema.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Project.Cinema.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	Movie findOneById(Long id);
	Page<Movie> findByNameIgnoreCaseContainsAndGenresIgnoreCaseContainsAndDurationBetweenAndDistributorIgnoreCaseContainsAndCountryOfOriginIgnoreCaseContainsAndYearOfProductionBetween(
			String name, String genres, Integer durationFrom, Integer durationTo, String distributor, String countryOfOrigin, Integer yearOfProductionFrom, Integer yearOfProductionTo, Pageable pageable);
	

}
