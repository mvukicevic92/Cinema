package Project.Cinema.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class MovieDTO {
	
	@Positive
	private Long id;

	@NotBlank(message = "Naziv filma nije zadat!")
	private String name;
	
	private String director;
	
	private String actors;
	
	private String genres;
	
	@Positive
	private Integer duration;
	
	@NotBlank(message = "Distributer nije zadat!")
	private String distributor;
	
	@NotBlank(message = "Zemlja porekla nije zadata!")
	private String countryOfOrigin;
	
	@Positive
	private Integer yearOfProduction;
	
	private String description;

	public MovieDTO() {
		super();
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
	
	
	
}
