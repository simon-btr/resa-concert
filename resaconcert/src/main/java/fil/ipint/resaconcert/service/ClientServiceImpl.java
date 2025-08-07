package fil.ipint.resaconcert.service;

import fil.ipint.resaconcert.entity.Billet;
import fil.ipint.resaconcert.entity.Client;
import fil.ipint.resaconcert.entity.Concert;
import fil.ipint.resaconcert.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ConcertService concertService;

    @Override
    public List<Client> getAll() {
        return (List<Client>) this.clientRepository.findAll();
    }

    @Override
    public Client getById(Long id) throws Exception {
        return clientRepository.findById(id)
                .orElseThrow( () ->
                        new Exception("Can't find client for id '" + id + "'")
                );
    }

    @Override
    public Client add(Client client) {
        Client c = new Client();
        c.setNom(client.getNom());
        c.setAdresse(client.getAdresse());
        clientRepository.save(c);
        return c;
    }

    @Override
    public Client update(Long id, Client client) throws Exception {
        Client updatedClient =  clientRepository.findById(id)
                .orElseThrow( () ->
                        new Exception("Can't find client for id '" + id + "'")
                );
        updatedClient.setNom(client.getNom());
        updatedClient.setBilletList(client.getBilletList());
        updatedClient.setAdresse(client.getAdresse());

        clientRepository.save(updatedClient);

        return  updatedClient;
    }

    @Override
    public void delete(Long id) throws Exception {
        clientRepository.deleteById(id);

    }

    public void bookTicket(Long clientId, Long concertId) throws Exception {
        Client updatedClient =  clientRepository.findById(clientId)
                .orElseThrow( () ->
                        new Exception("Can't find client for id '" + clientId + "'")
                );
        Concert concert = concertService.getConcertById(concertId);
        Billet billet = new Billet(concert);
        updatedClient.addBillet(billet);

        clientRepository.save(updatedClient);
    }

}
