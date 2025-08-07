package fil.ipint.resaconcert.repository;

import fil.ipint.resaconcert.entity.Salle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SalleRepository extends CrudRepository<Salle, Long> {

    List<Salle> findByNom(String nom);

    Salle findById(long id);
}
