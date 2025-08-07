package fil.ipint.resaconcert.DTO;

public class AdresseDTO {
    private long id;
    private String ville;
    private String rue;

    public AdresseDTO (long id, String ville, String rue) {
        this.id = id;
        this.ville = ville;
        this.rue= rue;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public long getId() {
        return id;
    }

    public String getVille() {
        return ville;
    }

    public String getRue() {
        return rue;
    }
}
