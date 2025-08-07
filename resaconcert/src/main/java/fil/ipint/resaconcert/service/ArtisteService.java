package fil.ipint.resaconcert.service;

import fil.ipint.resaconcert.entity.Artiste;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArtisteService {

    public List<Artiste> getAll();

    public Artiste getById(Long id) throws Exception;

    public Artiste add(Artiste artiste);

    public Artiste update(Long id, Artiste artiste) throws Exception ;

    public void delete(Long id) throws Exception ;
}
