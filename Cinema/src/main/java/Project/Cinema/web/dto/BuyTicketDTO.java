package Project.Cinema.web.dto;

public class BuyTicketDTO {
	
	private Long id;
	
	private Long ticketId;
	
	private Long projectionId;
	
	private String dateTimeOfPurchase;

	public BuyTicketDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Long getProjectionId() {
		return projectionId;
	}

	public void setProjectionId(Long projectionId) {
		this.projectionId = projectionId;
	}

	public String getDateTimeOfPurchase() {
		return dateTimeOfPurchase;
	}

	public void setDateTimeOfPurchase(String dateTimeOfPurchase) {
		this.dateTimeOfPurchase = dateTimeOfPurchase;
	}
	
	

}
