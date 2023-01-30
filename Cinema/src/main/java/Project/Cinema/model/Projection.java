package Project.Cinema.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Projection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Movie movie;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "type_of_projection_id")
	private Set<TypeOfProjection> typesOfProjection = new HashSet<>();
	
	@ManyToOne
	private Hall hall;
	
	@Column(nullable = false)
	private LocalDateTime dateTimeOfDisplay;
	
	@Column(nullable = false)
	private Double ticketPrice;

	public Projection() {
		super();
	}

	public Projection(Movie movie, Hall hall, LocalDateTime dateTimeOfDisplay, Double ticketPrice) {
		super();
		this.movie = movie;
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
	}

	public Set<TypeOfProjection> getTypesOfProjection() {
		return typesOfProjection;
	}

	public void setTypesOfProjection(Set<TypeOfProjection> typesOfProjection) {
		this.typesOfProjection = typesOfProjection;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
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
		return "Projection [id=" + id + ", movie=" + movie.getName() + ", hall=" + hall.getName() + ", dateTimeOfDisplay="
				+ dateTimeOfDisplay + ", ticketPrice=" + ticketPrice + "]";
	}
	
}
