package Project.Cinema.web.dto;

import javax.validation.constraints.Positive;

public class TicketDTO {
	
	@Positive
	private Long id;
	
	private ProjectionDTO projection;
	
	@Positive
	private SeatDTO seat;
	
	private String dateTimeOfPurchase;

	public TicketDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProjectionDTO getProjection() {
		return projection;
	}

	public void setProjection(ProjectionDTO projection) {
		this.projection = projection;
	}

	public SeatDTO getSeat() {
		return seat;
	}

	public void setSeat(SeatDTO seat) {
		this.seat = seat;
	}

	public String getDateTimeOfPurchase() {
		return dateTimeOfPurchase;
	}

	public void setDateTimeOfPurchase(String dateTimeOfPurchase) {
		this.dateTimeOfPurchase = dateTimeOfPurchase;
	}
	
	

}
