package fil.ipint.resaconcert.service;

import fil.ipint.resaconcert.entity.Salle;
import fil.ipint.resaconcert.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleServiceImpl implements SalleService{
    @Autowired
    private SalleRepository salleRepository;

    @Override
    public List<Salle> getAll() {
        return (List<Salle>) this.salleRepository.findAll();
    }

    @Override
    public Salle getById(Long id) throws Exception {
        return salleRepository.findById(id)
                .orElseThrow( () ->
                        new Exception("Can't find salle for id '" + id + "'")
                );
    }

    @Override
    public Salle add(Salle salle) {
        Salle s = new Salle();
        s.setNom(salle.getNom());
        salleRepository.save(s);
        return s;
    }

    @Override
    public Salle update(Long id, Salle salle) throws Exception {
        Salle updatedSalle =  salleRepository.findById(id)
                .orElseThrow( () ->
                        new Exception("Can't find salle for id '" + id + "'")
                );
        updatedSalle.setNom(salle.getNom());

        salleRepository.save(updatedSalle);

        return  updatedSalle;
    }

    @Override
    public void delete(Long id) throws Exception {
        salleRepository.deleteById(id);
    }
}
