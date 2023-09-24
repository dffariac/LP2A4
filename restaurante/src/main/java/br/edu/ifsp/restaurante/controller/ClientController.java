package br.edu.ifsp.restaurante.controller;

import br.edu.ifsp.restaurante.dto.client.ClientRequest;
import br.edu.ifsp.restaurante.dto.client.ClientResponse;
import br.edu.ifsp.restaurante.mapper.address.AddressMapper;
import br.edu.ifsp.restaurante.mapper.client.ClientMapper;
import br.edu.ifsp.restaurante.model.Client;
import br.edu.ifsp.restaurante.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientResponse>> showAll(){
        List<ClientResponse> response = this.clientService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientResponse> createClient(@RequestBody ClientRequest request) {
        ClientResponse response = this.clientService.save(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<ClientResponse> editClient(@PathVariable Long clientId, @RequestBody ClientRequest request) {
        Client client = ClientMapper.responseToClient(this.clientService.findById(clientId));
        client.setName(request.name());
        client.setAddress(AddressMapper.responseToAddress(request.address()));
        ClientResponse response = this.clientService.save(client);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long clientId) {
        this.clientService.deleteById(clientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
