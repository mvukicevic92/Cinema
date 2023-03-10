package Project.Cinema.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(unique = true)
	private Integer serialNumber;
	
	@ManyToOne
	private Hall hall;

	public Seat() {
		super();
	}

	public Seat(Hall hall) {
		super();
		this.hall = hall;
	}

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	@Override
	public int hashCode() {
		return Objects.hash(serialNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seat other = (Seat) obj;
		return Objects.equals(serialNumber, other.serialNumber);
	}

	@Override
	public String toString() {
		return "Seat [serialNumber=" + serialNumber + ", hall=" + hall.getName() + "]";
	}

}
