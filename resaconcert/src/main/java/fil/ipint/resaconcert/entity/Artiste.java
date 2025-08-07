package fil.ipint.resaconcert.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artiste {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nom;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Artiste() {}

	public Artiste(String nom) {
		this.nom = nom;
	}

}
