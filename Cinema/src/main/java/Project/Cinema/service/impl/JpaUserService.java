package Project.Cinema.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Project.Cinema.enumeration.UserRole;
import Project.Cinema.model.User;
import Project.Cinema.repository.UserRepository;
import Project.Cinema.service.UserService;
import Project.Cinema.web.dto.UserChangePasswordDto;

@Service
public class JpaUserService implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Optional<User> findOne(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Page<User> findAll(Integer pageNo) {
		return userRepository.findAll(PageRequest.of(pageNo, 10));
	}

	@Override
	public User save(User user) {
		user.setRole(UserRole.USER);
		return userRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return userRepository.findFirstByUsername(username);
	}

	@Override
	public boolean changePassword(Long id, UserChangePasswordDto userChangePasswordDto) {
		Optional<User> result = userRepository.findById(id);
		if(!result.isPresent()) {
			throw new EntityNotFoundException();
		}
		User user = result.get();
	
		if(!user.getUsername().equals(userChangePasswordDto.getUsername()) || !user.getPassword().equals(userChangePasswordDto.getPassword())) {
			return false;
		}
		String password = userChangePasswordDto.getPassword();
		if(!userChangePasswordDto.getPassword().equals("")) {
			password = passwordEncoder.encode(userChangePasswordDto.getPassword());
		}
		user.setPassword(password);
		userRepository.save(user);
		return true;
	}

}
