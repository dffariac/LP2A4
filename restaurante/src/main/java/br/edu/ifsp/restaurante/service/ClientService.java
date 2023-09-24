package br.edu.ifsp.restaurante.service;

import br.edu.ifsp.restaurante.dto.client.ClientRequest;
import br.edu.ifsp.restaurante.dto.client.ClientResponse;
import br.edu.ifsp.restaurante.mapper.client.ClientMapper;
import br.edu.ifsp.restaurante.model.Client;
import br.edu.ifsp.restaurante.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<ClientResponse> findAll(){
        return this.clientRepository.findAll().stream().map(ClientMapper::clientToResponse).toList();
    }

    public ClientResponse findById(Long id){
        return this.clientRepository.findById(id).map(ClientMapper::clientToResponse)
                .orElseThrow(() -> new RuntimeException("client #"+id+" not found"));
    }

    public ClientResponse save(ClientRequest request){
        Client client = this.clientRepository.save(ClientMapper.requestToClient(request));
        return ClientMapper.clientToResponse(client);
    }

    public ClientResponse save(Client client){
        return ClientMapper.clientToResponse(this.clientRepository.save(client));
    }

    public void deleteById(Long id){
        this.clientRepository.deleteById(id);
    }
}
