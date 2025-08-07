package fil.ipint.resaconcert.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Billet {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Date dateDachat;
	@ManyToOne(cascade = CascadeType.DETACH)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Concert concert;

	protected Billet() {}

	public Billet (Date dateDachat,Concert concert) {
		this.dateDachat = dateDachat;
		this.concert = concert;
	}

	public Billet (Concert concert) {
		this.dateDachat = new Date();
		this.concert = concert;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDateDachat(Date dateDachat) {
		this.dateDachat = dateDachat;
	}

	public Long getId() {
		return id;
	}

	public Date getDateDachat() {
		return dateDachat;
	}

	public Concert getConcert() {
		return concert;
	}

	public void setConcert(Concert concert) {
		this.concert = concert;
	}
}