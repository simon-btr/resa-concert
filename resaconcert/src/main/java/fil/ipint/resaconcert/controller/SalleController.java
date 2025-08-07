package fil.ipint.resaconcert.controller;

import fil.ipint.resaconcert.DTO.SalleDTO;
import fil.ipint.resaconcert.entity.Salle;
import fil.ipint.resaconcert.service.SalleServiceImpl;
import fil.ipint.resaconcert.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("salle")
@CrossOrigin(origins = "http://localhost:3000")
public class SalleController {
    @Autowired
    Mapper mapper = new Mapper();

    @Autowired
    SalleServiceImpl salleService;

    @GetMapping("")
    @ResponseBody
    public List<SalleDTO> getAll () {
        return salleService.getAll()
                .stream()
                .map(mapper::toSalleDTO)
                .collect(toList());
    }

    @GetMapping("/{id}")
    public SalleDTO getById(@Valid @PathVariable Long id) throws Exception {
        return mapper.toSalleDTO(salleService.getById(id));
    }

    @PostMapping("")
    @ResponseBody
    public SalleDTO create(@Valid @RequestBody SalleDTO salleDTO) {
        Salle salle = mapper.toSalle(salleDTO);

        Salle s = salleService.add(salle);

        return new SalleDTO(s.getId(), s.getNom());
    }

    @PutMapping("/{id}")
    public SalleDTO update(@Valid @PathVariable Long id, @Valid @RequestBody SalleDTO salleDTO) throws Exception {
        Salle salle = mapper.toSalle(salleDTO);

        Salle s = salleService.update(id, salle);

        return new SalleDTO(s.getId(), s.getNom());
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) throws Exception {
        salleService.delete(id);
    }
}
