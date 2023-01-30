package Project.Cinema.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class HallDTO {
	@Positive
	private Long id;
	
	@NotBlank(message = "Naziv sale nije zadato!")
	private String name;

	public HallDTO() {
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
