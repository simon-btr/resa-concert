package fil.ipint.resaconcert.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
public class Concert {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String titre;
	private long prix;
	private LocalDate date;
	@ManyToOne(cascade = CascadeType.DETACH)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Artiste artiste;
	@ManyToOne(cascade = CascadeType.DETACH)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Salle salle;
	
	public Concert() {}

	public Concert (String titre) {
		this.titre = titre;
	}

	public Concert (String titre, long prix, LocalDate date, Artiste artiste, Salle salle) {
		this.titre = titre;
		this.prix = prix;
		this.date = date;
		this.artiste = artiste;
		this.salle = salle;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setTitre(String nom) {
		this.titre = nom;
	}

	public void setDate(LocalDate localDate) {
		this.date = localDate;
	}

	public void setPrix(long prix) {
		this.prix = prix;
	}
	
	public Long getId() {
		return id;
	}

	public String getTitre() {
		return titre;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public long getPrix() {
		return prix;
	}

	public Artiste getArtiste() {
		return artiste;
	}

	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}
}