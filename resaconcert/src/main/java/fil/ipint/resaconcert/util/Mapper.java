package fil.ipint.resaconcert.util;

import fil.ipint.resaconcert.DTO.*;
import fil.ipint.resaconcert.entity.*;
import fil.ipint.resaconcert.service.ArtisteServiceImpl;
import fil.ipint.resaconcert.service.ConcertService;
import fil.ipint.resaconcert.service.SalleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Mapper {

    @Autowired
    private ArtisteServiceImpl artisteService;

    @Autowired
    private SalleServiceImpl salleService;

    @Autowired
    private ConcertService concertService;

    public ConcertDTO toConcertDto(Concert concert) {
        long id = concert.getId();
        String nom = concert.getTitre();
        long prix = concert.getPrix();
        LocalDate date = concert.getDate();
        long artisteId = concert.getArtiste().getId();
        long salleId = concert.getSalle().getId();

        return new ConcertDTO(id, nom, prix, date, artisteId, salleId);
    }

    public Concert toConcert(ConcertDTO concertDTO) throws Exception {
        Artiste a = artisteService.getById(concertDTO.getArtisteId());
        Salle s = salleService.getById(concertDTO.getSalleId());
        return new Concert(concertDTO.getTitre(), concertDTO.getPrix(), concertDTO.getDate(), a, s);
    }

    public ArtisteDTO toArtisteDto(Artiste artiste) {
        long id = artiste.getId();
        String nom = artiste.getNom();

        return new ArtisteDTO(id, nom);
    }

    public Artiste toArtiste(ArtisteDTO artisteDTO) {
        return new Artiste(artisteDTO.getNom());
    }

    public SalleDTO toSalleDTO(Salle salle) {
        long id = salle.getId();
        String nom = salle.getNom();

        return new SalleDTO(id, nom);
    }

    public Salle toSalle(SalleDTO salleDTO) {
        return new Salle(salleDTO.getNom());
    }

    public BilletDTO toBilletDTO(Billet billet) {
        long id = billet.getId();
        Date dateDachat = billet.getDateDachat();
        long concertId = billet.getConcert().getId();
        String concertTitre = billet.getConcert().getTitre();
        String concertArtiste = billet.getConcert().getArtiste().getNom();
        long concertPrix = billet.getConcert().getPrix();
        LocalDate concertDate = billet.getConcert().getDate();
        String concertSalle = billet.getConcert().getSalle().getNom();

        return new BilletDTO(id, dateDachat, concertId, concertTitre, concertArtiste, concertPrix, concertDate, concertSalle);
    }

    public Billet toBillet(BilletDTO billetDTO) throws Exception {
        Concert c = concertService.getConcertById(billetDTO.getConcertId());
        return new Billet(billetDTO.getDateDachat(), c);
    }

    public AdresseDTO toAdresseDTO(Adresse adresse) {
        long id = adresse.getId();
        String ville = adresse.getVille();
        String rue = adresse.getRue();

        return new AdresseDTO(id, ville, rue);
    }

    public Adresse toAdresse(AdresseDTO adresseDTO) {
        return new Adresse(adresseDTO.getVille(), adresseDTO.getRue());
    }

    public ClientDTO toClientDTO(Client client) {
        long id = client.getId();
        String nom = client.getNom();
        List<BilletDTO> billetDTOList = new ArrayList<BilletDTO>();
        for (Billet b : client.getBilletList()) {
            billetDTOList.add(toBilletDTO(b));
        }
        AdresseDTO adresseDTO = toAdresseDTO(client.getAdresse());

        return new ClientDTO(id, nom, billetDTOList, adresseDTO);
    }

    public Client toClient(ClientDTO clientDTO) throws Exception {
        List<Billet> billetList = new ArrayList<Billet>();
        if (clientDTO.getBilletDTOList() != null) {
            for (BilletDTO b : clientDTO.getBilletDTOList()) {
                billetList.add(toBillet(b));
            }
        }
        Adresse adresse = toAdresse(clientDTO.getAdresseDTO());

        return new Client(clientDTO.getNom(), billetList, adresse);
    }
}