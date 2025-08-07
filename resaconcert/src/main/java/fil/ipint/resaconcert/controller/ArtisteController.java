package fil.ipint.resaconcert.controller;

import fil.ipint.resaconcert.DTO.ArtisteDTO;
import fil.ipint.resaconcert.DTO.ClientDTO;
import fil.ipint.resaconcert.entity.Artiste;
import fil.ipint.resaconcert.service.ArtisteServiceImpl;
import fil.ipint.resaconcert.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("artiste")
@CrossOrigin(origins = "http://localhost:3000")
public class ArtisteController {

    @Autowired
    Mapper mapper = new Mapper();

    @Autowired
    ArtisteServiceImpl artisteService;

    @GetMapping("")
    @ResponseBody
    public List<ArtisteDTO> getAll () {
        return artisteService.getAll()
                .stream()
                .map(mapper::toArtisteDto)
                .collect(toList());
    }

    @GetMapping("/{id}")
    public ArtisteDTO getById(@Valid @PathVariable Long id) throws Exception {
        return mapper.toArtisteDto(artisteService.getById(id));
    }

    @PostMapping("")
    @ResponseBody
    public ArtisteDTO create(@Valid @RequestBody ArtisteDTO artisteDTO) {
        Artiste artiste = mapper.toArtiste(artisteDTO);

        Artiste a = artisteService.add(artiste);

        return new ArtisteDTO(a.getId(), a.getNom());
    }

    @PutMapping("/{id}")
    public ArtisteDTO update(@Valid @PathVariable Long id, @Valid @RequestBody ArtisteDTO artisteDTO) throws Exception {
        Artiste artiste = mapper.toArtiste(artisteDTO);

        Artiste a = artisteService.update(id, artiste);

        return new ArtisteDTO(a.getId(), a.getNom());
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) throws Exception {
        artisteService.delete(id);
    }
}
