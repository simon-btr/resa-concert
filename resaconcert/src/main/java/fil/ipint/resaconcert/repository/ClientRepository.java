package fil.ipint.resaconcert.repository;

import fil.ipint.resaconcert.entity.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> findByNom(String nom);

    Client findById(long id);
}
