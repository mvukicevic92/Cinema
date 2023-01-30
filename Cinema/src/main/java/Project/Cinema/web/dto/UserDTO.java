package Project.Cinema.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserDTO {
	
	private Long id;
	
	@NotBlank(message = "Username nije unet!")
	@Pattern(regexp = "^[a-zA-Z0-9]+$" , message = "Username nije validan!")
	private String username;
	
	private String dateOfRegistration;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}
	
	

}
