package fil.ipint.resaconcert.repository;

import fil.ipint.resaconcert.entity.Artiste;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtisteRepository extends CrudRepository<Artiste, Long> {

    List<Artiste> findByNom(String nom);

    Artiste findById(long id);
}
