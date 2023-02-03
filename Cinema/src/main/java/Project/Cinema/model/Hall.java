package Project.Cinema.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Hall {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany
	@JoinColumn(name = "type_of_projection_id")
	private Set<TypeOfProjection> typesOfProjections = new HashSet<>();
	
	@OneToMany(mappedBy = "hall")
	private Set<Projection> projections = new HashSet<>();

	public Hall() {
		super();
	}

	public Hall(String name) {
		super();
		this.name = name;
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

	public Set<TypeOfProjection> getTypesOfProjections() {
		return typesOfProjections;
	}

	public void setTypesOfProjections(Set<TypeOfProjection> typesOfProjections) {
		this.typesOfProjections = typesOfProjections;
	}
	
	public Set<Projection> getProjections() {
		return projections;
	}

	public void setProjections(Set<Projection> projections) {
		this.projections = projections;
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
		Hall other = (Hall) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Hall [id=" + id + ", name=" + name + "]";
	}

}
