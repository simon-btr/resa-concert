package fil.ipint.resaconcert.controller;

import fil.ipint.resaconcert.DTO.ConcertDTO;
import fil.ipint.resaconcert.entity.*;
import fil.ipint.resaconcert.service.ConcertServiceImpl;

import fil.ipint.resaconcert.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("concert")
@CrossOrigin(origins = "http://localhost:3000")
public class ConcertController {

	@Autowired
	Mapper mapper = new Mapper();
	@Autowired
	ConcertServiceImpl concertService;

	@GetMapping("/create")
	public Concert createConcert(
			@RequestParam(value = "nom", defaultValue = "unknown")String nom,
			@RequestParam(value = "prix", defaultValue = "100") long prix
	) throws NotFoundException {

		return concertService.createConcert(nom, prix);
	}

	@GetMapping("")
	@ResponseBody
	public List<ConcertDTO> getConcerts () {
		return concertService.getAllConcerts()
				.stream()
				.map(mapper::toConcertDto)
				.collect(toList());
	}

	@GetMapping("/{id}")
	public ConcertDTO getConcertById(@Valid @PathVariable Long id) throws Exception {
		return mapper.toConcertDto(concertService.getConcertById(id));
	}

	@PostMapping("")
	@ResponseBody
	public ConcertDTO create(@Valid @RequestBody ConcertDTO concertDTO) throws Exception {
		Concert concert = mapper.toConcert(concertDTO);

		Concert c = concertService.createConcertJSON(concert);

		return new ConcertDTO(c.getId(), c.getTitre(), c.getPrix(), c.getDate(), c.getArtiste().getId(), c.getSalle().getId());
	}

	@PutMapping("/{id}")
	public ConcertDTO updateConcert(@Valid @PathVariable Long id, @Valid @RequestBody ConcertDTO concertDTO) throws Exception {
		Concert concert = mapper.toConcert(concertDTO);

		Concert c = concertService.updateConcert(id, concert);

		return new ConcertDTO(c.getId(), c.getTitre(), c.getPrix(), c.getDate(), c.getArtiste().getId(), c.getSalle().getId());
	}

	@DeleteMapping("/{id}")
	public void deleteConcert(
			@PathVariable Long id
	) throws Exception {
		concertService.deleteConcert(id);
	}

}