package Project.Cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Project.Cinema.model.User;
import Project.Cinema.web.dto.UserDTO;

@Component
public class UserToUserDto implements Converter<User, UserDTO>{

	@Override
	public UserDTO convert(User user) {
		UserDTO userDto = new UserDTO();
		userDto.setId(user.getId());
		userDto.setUsername(user.getUsername());
		userDto.setDateOfRegistration(user.getDateOfRegistration().toString());
		return userDto;
	}
	
	public List<UserDTO> convert(List<User> users){
		List<UserDTO> usersDto = new ArrayList<>();
		for(User user : users) {
			UserDTO userDto = convert(user);
			usersDto.add(userDto);
		}
		return usersDto;
	}

}
