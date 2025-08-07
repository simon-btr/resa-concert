package fil.ipint.resaconcert.DTO;

import fil.ipint.resaconcert.entity.Billet;

import java.util.List;

public class ClientDTO {
    private Long id;
    private String nom;
    private List<BilletDTO> billetDTOList;
    private AdresseDTO adresseDTO;

    public ClientDTO(Long id, String nom, List<BilletDTO> billetDTOList, AdresseDTO adresseDTO) {
        this.id = id;
        this.nom = nom;
        this.billetDTOList = billetDTOList;
        this.adresseDTO = adresseDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<BilletDTO> getBilletDTOList() {
        return billetDTOList;
    }

    public void setBilletDTOList(List<BilletDTO> billetDTOList) {
        this.billetDTOList = billetDTOList;
    }

    public void addBillet(BilletDTO billetDTO) {
        this.billetDTOList.add(billetDTO);
    }

    public void removeBillet(BilletDTO billetDTO) {
        this.billetDTOList.remove(billetDTO);
    }

    public AdresseDTO getAdresseDTO() {
        return adresseDTO;
    }

    public void setAdresseDTO(AdresseDTO adresseDTO) {
        this.adresseDTO = adresseDTO;
    }
}
