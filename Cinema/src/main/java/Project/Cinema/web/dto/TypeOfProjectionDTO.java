package Project.Cinema.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class TypeOfProjectionDTO {
	
	@Positive
	private Long id;
	
	@NotBlank(message = "Tip projekcije nije zadat!")
	private String name;

	public TypeOfProjectionDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
