package Project.Cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import Project.Cinema.model.User;
import Project.Cinema.web.dto.UserChangePasswordDto;

public interface UserService {
	
	Optional<User> findOne(Long id);
	List<User> findAll();
	Page<User> findAll(Integer pageNo);
	User save (User user);
	void delete (Long id);
	Optional<User> findByUsername (String username);
	boolean changePassword(Long id, UserChangePasswordDto userChangePasswordDto);

}
