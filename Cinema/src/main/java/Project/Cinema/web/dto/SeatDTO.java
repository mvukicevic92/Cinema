package Project.Cinema.web.dto;

import javax.validation.constraints.Positive;

public class SeatDTO {
	
	@Positive
	private Integer serialNumber;
	
	private HallDTO hall;

	public SeatDTO() {
		super();
	}

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	public HallDTO getHall() {
		return hall;
	}

	public void setHall(HallDTO hall) {
		this.hall = hall;
	}
	
	

}
