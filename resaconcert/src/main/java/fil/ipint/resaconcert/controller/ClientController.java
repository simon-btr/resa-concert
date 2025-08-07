package fil.ipint.resaconcert.controller;

import fil.ipint.resaconcert.DTO.AdresseDTO;
import fil.ipint.resaconcert.DTO.ArtisteDTO;
import fil.ipint.resaconcert.DTO.ClientDTO;
import fil.ipint.resaconcert.entity.Client;
import fil.ipint.resaconcert.service.ClientServiceImpl;
import fil.ipint.resaconcert.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("client")
@CrossOrigin(origins = "http://localhost:3000")
public class ClientController {

    @Autowired
    Mapper mapper = new Mapper();

    @Autowired
    ClientServiceImpl clientService;

    @GetMapping("")
    @ResponseBody
    public List<ClientDTO> getAll () {
        return clientService.getAll()
                .stream()
                .map(mapper::toClientDTO)
                .collect(toList());
    }

    @GetMapping("/{id}")
    public ClientDTO getById(@Valid @PathVariable Long id) throws Exception {
        return mapper.toClientDTO(clientService.getById(id));
    }

    @PostMapping("")
    @ResponseBody
    public ClientDTO create(@Valid @RequestBody ClientDTO clientDTO) throws Exception {
        Client client = mapper.toClient(clientDTO);

        Client c = clientService.add(client);

        return mapper.toClientDTO(c);
    }

    @PutMapping("/{id}")
    public ClientDTO update(@Valid @PathVariable Long id, @Valid @RequestBody ClientDTO clientDTO) throws Exception {
        Client client = mapper.toClient(clientDTO);

        Client c = clientService.update(id, client);

        return mapper.toClientDTO(c);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) throws Exception {
        clientService.delete(id);
    }

    @PutMapping("{clientId}/book/concert/{concertId}")
    public void bookTicket(@Valid @PathVariable Long clientId, @Valid @PathVariable Long concertId) throws Exception {
        clientService.bookTicket(clientId, concertId);
    }
}

