package fil.ipint.resaconcert.DTO;

import java.time.LocalDate;

public class ConcertDTO {

    private long id;
    private String titre;
    private long prix;
    private LocalDate date;
    private long artisteId;
    private long salleId;

    public ConcertDTO(long id, String titre, long prix, LocalDate date, long artisteId, long salleId) {
        this.id = id;
        this.titre = titre;
        this.prix = prix;
        this.date = date;
        this.artisteId = artisteId;
        this.salleId = salleId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getPrix() {
        return prix;
    }

    public void setPrix(long prix) {
        this.prix = prix;
    }

    public long getArtisteId() {
        return artisteId;
    }

    public void setArtisteId(long artisteId) {
        this.artisteId = artisteId;
    }

    public long getSalleId() {
        return salleId;
    }

    public void setSalleId(long salleId) {
        this.salleId = salleId;
    }
}
