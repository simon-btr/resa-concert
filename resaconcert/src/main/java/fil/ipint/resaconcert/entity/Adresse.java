package fil.ipint.resaconcert.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String ville;
	private String rue;

	public Adresse() {}

	public Adresse (String ville, String rue) {
		this.ville = ville;
		this.rue= rue;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public Long getId() {
		return id;
	}

	public String getVille() {
		return ville;
	}
	
	public String getRue() {
		return rue;
	}
}