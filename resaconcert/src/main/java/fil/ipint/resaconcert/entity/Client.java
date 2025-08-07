package fil.ipint.resaconcert.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nom;
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "billet_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Billet> billetList = new ArrayList<Billet>();
	@ManyToOne(cascade = {CascadeType.ALL})
	private Adresse adresse;

	public Client() {}

	public Client (String nom, Adresse adresse) {
		this.nom = nom;
		this.adresse = adresse;
	}

	public Client (String nom, List<Billet> billetList, Adresse adresse) {
		this.nom = nom;
		this.billetList = billetList;
		this.adresse = adresse;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Billet> getBilletList() {
		return billetList;
	}

	public void setBilletList(List<Billet> billets) {
		this.billetList = billets;
	}

	public void addBillet(Billet billet) {
		this.billetList.add(billet);
	}

	public void removeBillet(Billet billet) {
		this.billetList.remove(billet);
	}
}