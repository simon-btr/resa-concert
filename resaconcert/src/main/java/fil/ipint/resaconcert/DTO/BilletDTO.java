package fil.ipint.resaconcert.DTO;

import java.time.LocalDate;
import java.util.Date;

public class BilletDTO {
    private Long id;
    private Date dateDachat;
    private long concertId;
    private String concertTitre;
    private String concertArtiste;
    private long concertPrix;
    private LocalDate concertDate;
    private String concertSalle;

    public BilletDTO (long id, Date dateDachat, long concertId, String concertTitre, String concertArtiste, long concertPrix, LocalDate concertDate, String concertSalle) {
        this.id = id;
        this.dateDachat = dateDachat;
        this.concertId = concertId;
        this.concertTitre = concertTitre;
        this.concertArtiste = concertArtiste;
        this.concertPrix = concertPrix;
        this.concertDate = concertDate;
        this.concertSalle = concertSalle;
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

    public long getConcertId() {
        return concertId;
    }

    public void setConcertId(long concertId) {
        this.concertId = concertId;
    }

    public String getConcertTitre() {
        return concertTitre;
    }

    public void setConcertTitre(String concertTitre) {
        this.concertTitre = concertTitre;
    }

    public String getConcertArtiste() {
        return concertArtiste;
    }

    public void setConcertArtiste(String concertArtiste) {
        this.concertArtiste = concertArtiste;
    }

    public long getConcertPrix() {
        return concertPrix;
    }

    public void setConcertPrix(long concertPrix) {
        this.concertPrix = concertPrix;
    }

    public LocalDate getConcertDate() {
        return concertDate;
    }

    public void setConcertDate(LocalDate concertDate) {
        this.concertDate = concertDate;
    }

    public String getConcertSalle() {
        return concertSalle;
    }

    public void setConcertSalle(String concertSalle) {
        this.concertSalle = concertSalle;
    }
}
