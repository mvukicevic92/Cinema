package Project.Cinema.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserChangePasswordDto {
	
	private String username;
	
	private String oldPassword;
	
	@NotBlank(message = "Password nije unet!")
	@Pattern(regexp = "^[a-zA-Z0-9]+$" , message = "Password nije validan!")
	private String password;
	
	private String repeatedPassword;

	public UserChangePasswordDto() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatedPassword() {
		return repeatedPassword;
	}

	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}
	
	

}
