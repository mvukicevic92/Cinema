package Project.Cinema.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Projection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	@ManyToOne
	private Movie movie;
	
	@ManyToOne
//	@JoinColumn(name = "type_of_projection_id")
	@PrimaryKeyJoinColumn
	private TypeOfProjection typeOfProjection;
	
	@ManyToOne
	private Hall hall;
	
	@Column(nullable = false)
	private LocalDateTime dateTimeOfDisplay;
	
	@Column(nullable = false)
	private Double ticketPrice;
	
//	private User user;

	public Projection() {
		super();
	}

	public Projection(Movie movie, TypeOfProjection typeOfProjection, Hall hall, LocalDateTime dateTimeOfDisplay,
			Double ticketPrice) {
		super();
		this.movie = movie;
		this.typeOfProjection = typeOfProjection;
		this.hall = hall;
		this.dateTimeOfDisplay = dateTimeOfDisplay;
		this.ticketPrice = ticketPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
		if(movie != null & !movie.getProjections().contains(this)) {
			movie.getProjections().add(this);
		}
	}

	public TypeOfProjection getTypeOfProjection() {
		return typeOfProjection;
	}

	public void setTypeOfProjection(TypeOfProjection typeOfProjection) {
		this.typeOfProjection = typeOfProjection;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
		if(hall != null & !hall.getProjections().contains(this)) {
			hall.getProjections().add(this);
		}
	}

	public LocalDateTime getDateTimeOfDisplay() {
		return dateTimeOfDisplay;
	}

	public void setDateTimeOfDisplay(LocalDateTime dateTimeOfDisplay) {
		this.dateTimeOfDisplay = dateTimeOfDisplay;
	}

	public Double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
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
		Projection other = (Projection) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Projection [id=" + id + ", movie=" + movie.getName() + ", typeOfProjection=" + typeOfProjection.getName() + ", hall=" + hall.getName()
				+ ", dateTimeOfDisplay=" + dateTimeOfDisplay + ", ticketPrice=" + ticketPrice + "]";
	}

	
	
}
