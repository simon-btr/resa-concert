package fil.ipint.resaconcert.service;

import fil.ipint.resaconcert.entity.Salle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SalleService {
    public List<Salle> getAll();

    public Salle getById(Long id) throws Exception;

    public Salle add(Salle salle);

    public Salle update(Long id, Salle salle) throws Exception ;

    public void delete(Long id) throws Exception ;
}
