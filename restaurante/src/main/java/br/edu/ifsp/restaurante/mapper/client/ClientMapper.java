package br.edu.ifsp.restaurante.mapper.client;

import br.edu.ifsp.restaurante.dto.client.ClientRequest;
import br.edu.ifsp.restaurante.dto.client.ClientResponse;
import br.edu.ifsp.restaurante.mapper.address.AddressMapper;
import br.edu.ifsp.restaurante.mapper.order.OrderMapper;
import br.edu.ifsp.restaurante.model.Client;

import java.util.List;

public class ClientMapper {

    public static ClientResponse clientToResponse(Client client) {
        return new ClientResponse(client.getId(), client.getName(), AddressMapper.addressToResponse(client.getAddress()), OrderMapper.ordersToResponse(client.getOrders()));
    }

    public static Client requestToClient(ClientRequest request) {
        Client client = new Client();
        client.setName(request.name());
        client.setAddress(AddressMapper.responseToAddress(request.address()));
        return client;
    }

    public static Client responseToClient(ClientResponse response) {
        Client client = new Client();
        client.setId(response.id());
        client.setName(response.name());
        client.setAddress(AddressMapper.responseToAddress(response.address()));
        return client;
    }
}
