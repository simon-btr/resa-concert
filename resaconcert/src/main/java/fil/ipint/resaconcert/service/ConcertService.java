package fil.ipint.resaconcert.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import fil.ipint.resaconcert.entity.Concert;

@Service
public interface ConcertService {

	public List<Concert> getAllConcerts ();
	
	public Concert getConcertById(Long id) throws Exception;
	
	public Concert createConcert(String titre, long prix);

	public Concert createConcertJSON(Concert concert);

	public Concert updateConcert(Long id, Concert concert) throws Exception ;

	public void deleteConcert(Long id) throws Exception ;

}
