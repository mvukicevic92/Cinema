package Project.Cinema.support;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Project.Cinema.model.User;
import Project.Cinema.service.UserService;
import Project.Cinema.web.dto.UserDTO;

@Component
public class UserDtoToUser implements Converter<UserDTO, User>{
	
	@Autowired
	private UserService userService;

	@Override
	public User convert(UserDTO userDto) {
		User user = null;
		if(userDto.getId() != null) {
			user = userService.findOne(userDto.getId()).get();
		}
		if(user == null) {
			user = new User();
		}
		user.setUsername(userDto.getUsername());
		user.setDateOfRegistration(LocalDate.now());
		return user;
	}
	
//    private LocalDate getLocalDate(String date) throws DateTimeParseException {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        return LocalDate.parse(date, formatter);
//    }

}
