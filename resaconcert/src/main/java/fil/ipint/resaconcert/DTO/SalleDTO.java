package fil.ipint.resaconcert.DTO;

public class SalleDTO {
    private Long id;
    private String nom;

    public SalleDTO (Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

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
}
