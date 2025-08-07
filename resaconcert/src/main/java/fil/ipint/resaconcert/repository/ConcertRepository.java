package fil.ipint.resaconcert.repository;

import java.util.List;

import fil.ipint.resaconcert.entity.*;
import org.springframework.data.repository.CrudRepository;

public interface ConcertRepository extends CrudRepository<Concert, Long> {

	List<Concert> findByTitre(String titre);

	Concert findById(long id);
}
