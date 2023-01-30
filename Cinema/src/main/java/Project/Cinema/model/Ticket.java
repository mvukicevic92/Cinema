package Project.Cinema.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Projection projection;
	
	@OneToOne
	@JoinColumn(name = "seat_number", referencedColumnName = "serialNumber")
	private Seat seat;
	
	@Column
	private LocalDateTime dateTimeOfPurchase;

	public Ticket() {
		super();
	}

	public Ticket(Projection projection, Seat seat, LocalDateTime dateTimeOfPurchase) {
		super();
		this.projection = projection;
		this.seat = seat;
		this.dateTimeOfPurchase = dateTimeOfPurchase;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Projection getProjection() {
		return projection;
	}

	public void setProjection(Projection projection) {
		this.projection = projection;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public LocalDateTime getDateTimeOfPurchase() {
		return dateTimeOfPurchase;
	}

	public void setDateTimeOfPurchase(LocalDateTime dateTimeOfPurchase) {
		this.dateTimeOfPurchase = dateTimeOfPurchase;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", projection=" + projection.getDateTimeOfDisplay() + ", seat=" + seat.getSerialNumber() + ", dateTimeOfPurchase="
				+ dateTimeOfPurchase + "]";
	}

	

}
