package Project.Cinema.web.dto;

import javax.validation.constraints.Positive;

public class ReportDTO {
	
	private String movieName;
	
	@Positive
	private Integer numOfProjections;
	
	@Positive
	private Integer numOfTicketsSold;
	
	@Positive
	private Double sum;

	public ReportDTO() {
		super();
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Integer getNumOfProjections() {
		return numOfProjections;
	}

	public void setNumOfProjections(Integer numOfProjections) {
		this.numOfProjections = numOfProjections;
	}

	public Integer getNumOfTicketsSold() {
		return numOfTicketsSold;
	}

	public void setNumOfTicketsSold(Integer numOfTicketsSold) {
		this.numOfTicketsSold = numOfTicketsSold;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

}
