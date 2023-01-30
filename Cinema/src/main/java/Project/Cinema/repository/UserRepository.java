package Project.Cinema.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Project.Cinema.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findFirstByUsername(String username);

}
