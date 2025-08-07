package fil.ipint.resaconcert.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.ipint.resaconcert.entity.Concert;
import fil.ipint.resaconcert.repository.ConcertRepository;

@Service
public class ConcertServiceImpl implements ConcertService {

	@Autowired
	private ConcertRepository concertRepository;
	
	@Override
	public List<Concert> getAllConcerts() {
		return (List<Concert>) this.concertRepository.findAll();
	}

	@Override
	public Concert getConcertById(Long id) throws Exception {
		return concertRepository.findById(id)
				.orElseThrow( () ->
				new Exception("Can't find concert for id '" + id + "'")
				);
	}

	@Override
	public Concert createConcert(String titre, long prix) {
		Concert c = new Concert();
		c.setTitre(titre);
		c.setPrix(prix);
		c.setDate( LocalDate.now() );
		concertRepository.save(c);
		return c;
	}

	@Override
	public Concert createConcertJSON(Concert concert) {
		Concert c = new Concert();
		c.setTitre(concert.getTitre());
		c.setPrix(concert.getPrix());
		c.setDate(LocalDate.now());
		c.setArtiste(concert.getArtiste());
		c.setSalle(concert.getSalle());
		concertRepository.save(c);
		return c;
	}

	@Override
	public Concert updateConcert(Long id, Concert concert) throws Exception  {
		Concert updateConcert = concertRepository.findById(id)
				.orElseThrow( () ->
						new Exception("Can't find concert for id '" + id + "'")
				);
		updateConcert.setTitre(concert.getTitre());
		updateConcert.setPrix(concert.getPrix());
		updateConcert.setDate(concert.getDate());
		updateConcert.setArtiste(concert.getArtiste());
		updateConcert.setSalle(concert.getSalle());
		concertRepository.save(updateConcert);

		return updateConcert;
	}

	@Override
	public void deleteConcert(Long id) throws Exception {
		concertRepository.deleteById(id);
	}


}
