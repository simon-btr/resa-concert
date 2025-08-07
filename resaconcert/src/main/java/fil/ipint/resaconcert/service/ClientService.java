package fil.ipint.resaconcert.service;

import fil.ipint.resaconcert.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {
    public List<Client> getAll();

    public Client getById(Long id) throws Exception;

    public Client add(Client client);

    public Client update(Long id, Client client) throws Exception ;

    public void delete(Long id) throws Exception ;
}
