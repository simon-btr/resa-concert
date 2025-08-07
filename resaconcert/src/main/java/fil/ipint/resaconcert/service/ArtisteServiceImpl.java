package fil.ipint.resaconcert.service;

import fil.ipint.resaconcert.entity.Artiste;
import fil.ipint.resaconcert.repository.ArtisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtisteServiceImpl implements ArtisteService {

    @Autowired
    private ArtisteRepository artisteRepository;

    @Override
    public List<Artiste> getAll() {
        return (List<Artiste>) this.artisteRepository.findAll();
    }

    @Override
    public Artiste getById(Long id) throws Exception {
        return artisteRepository.findById(id)
                .orElseThrow( () ->
                        new Exception("Can't find artiste for id '" + id + "'")
                );
    }

    @Override
    public Artiste add(Artiste artiste) {
        Artiste a = new Artiste();
        a.setNom(artiste.getNom());
        artisteRepository.save(a);
        return a;
    }

    @Override
    public Artiste update(Long id, Artiste artiste) throws Exception {
        Artiste updatedArtiste =  artisteRepository.findById(id)
                .orElseThrow( () ->
                        new Exception("Can't find artiste for id '" + id + "'")
                );
        updatedArtiste.setNom(artiste.getNom());

        artisteRepository.save(updatedArtiste);

        return  updatedArtiste;
    }

    @Override
    public void delete(Long id) throws Exception {
        artisteRepository.deleteById(id);
    }
}
