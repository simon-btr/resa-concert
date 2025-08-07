package fil.ipint.resaconcert.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Salle {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nom;

	public Long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Salle() {}
	
	public Salle (String nom) {
		this.nom = nom;
	}
}
