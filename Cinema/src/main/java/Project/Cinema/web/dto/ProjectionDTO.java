package Project.Cinema.web.dto;

import javax.validation.constraints.Positive;

public class ProjectionDTO {
	
	@Positive
	private Long id;

	private MovieDTO movie;
	
	private HallDTO hall;
	
	private String dateTimeOfDisplay;
	
	@Positive
	private Double ticketPrice;

	public ProjectionDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MovieDTO getMovie() {
		return movie;
	}

	public void setMovie(MovieDTO movie) {
		this.movie = movie;
	}

	public HallDTO getHall() {
		return hall;
	}

	public void setHall(HallDTO hall) {
		this.hall = hall;
	}

	public String getDateTimeOfDisplay() {
		return dateTimeOfDisplay;
	}

	public void setDateTimeOfDisplay(String dateTimeOfDisplay) {
		this.dateTimeOfDisplay = dateTimeOfDisplay;
	}

	public Double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	
}
