package Project.Cinema.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column
	private String director;
	
	@Column
	private String actors;
	
	@Column
	private String genres;
	
	@Column(nullable = false)
	private Integer duration;
	
	@Column(nullable = false)
	private String distributor;
	
	@Column(nullable = false)
	private String countryOfOrigin;
	
	@Column(nullable = false)
	private Integer yearOfProduction;
	
	@Column(length = 500)
	private String description;

	public Movie() {
		super();
	}

	public Movie(String name, String director, String actors, String genres, Integer duration, String distributor,
			String countryOfOrigin, Integer yearOfProduction, String description) {
		super();
		this.name = name;
		this.director = director;
		this.actors = actors;
		this.genres = genres;
		this.duration = duration;
		this.distributor = distributor;
		this.countryOfOrigin = countryOfOrigin;
		this.yearOfProduction = yearOfProduction;
		this.description = description;
	}

	public Movie(String name, Integer duration, String distributor, String countryOfOrigin, Integer yearOfProduction) {
		super();
		this.name = name;
		this.duration = duration;
		this.distributor = distributor;
		this.countryOfOrigin = countryOfOrigin;
		this.yearOfProduction = yearOfProduction;
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

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public Integer getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(Integer yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		Movie other = (Movie) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", director=" + director + ", actors=" + actors + ", genres="
				+ genres + ", duration=" + duration + ", distributor=" + distributor + ", countryOfOrigin="
				+ countryOfOrigin + ", yearOfProduction=" + yearOfProduction + ", description=" + description + "]";
	}

}
