package Project.Cinema.web.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Project.Cinema.model.User;
import Project.Cinema.security.TokenUtils;
import Project.Cinema.service.UserService;
import Project.Cinema.support.UserDtoToUser;
import Project.Cinema.support.UserToUserDto;
import Project.Cinema.web.dto.AuthUserDto;
import Project.Cinema.web.dto.UserChangePasswordDto;
import Project.Cinema.web.dto.UserDTO;
import Project.Cinema.web.dto.UserRegistrationDto;

@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDtoToUser toUser;
	
	@Autowired
	private UserToUserDto toUserDto;
	
	@Autowired
	private AuthenticationManager authenticationManger;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private TokenUtils tokenUtils;
	
	@PostMapping
	public ResponseEntity<UserDTO> create(@RequestBody @Validated UserRegistrationDto dto){
		if(dto.getId() != null || !dto.getPassword().equals(dto.getRepeatedPassword())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		User user = toUser.convert(dto);
		user.setPassword(dto.getPassword());
		return new ResponseEntity<>(toUserDto.convert(userService.save(user)), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> get(@PathVariable Long id){
		Optional<User> user = userService.findOne(id);
		
		if(user.isPresent()) {
			return new ResponseEntity<>(toUserDto.convert(user.get()), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> get(@RequestParam(defaultValue = "0") Integer pageNo){
		Page<User> users = userService.findAll(pageNo);
		return new ResponseEntity<>(toUserDto.convert(users.getContent()), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, params = "changePassword")
	public ResponseEntity<Void> changePassword(@PathVariable Long id, @RequestBody UserChangePasswordDto dto){
		if(!dto.getPassword().equals(dto.getRepeatedPassword())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		boolean result;
		try {
			result = userService.changePassword(id, dto);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if(result) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping(path = "/auth", method = RequestMethod.POST)
	public ResponseEntity authenticateUser(@RequestBody AuthUserDto dto) {
		UsernamePasswordAuthenticationToken authenticationToken = 
				new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
		Authentication authentication = authenticationManger.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		try {
			UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getUsername());
			return ResponseEntity.ok(tokenUtils.generateToken(userDetails));
		} catch (UsernameNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
