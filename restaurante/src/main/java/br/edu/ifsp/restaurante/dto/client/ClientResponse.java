package br.edu.ifsp.restaurante.dto.client;

import br.edu.ifsp.restaurante.dto.address.AddressResponse;
import br.edu.ifsp.restaurante.dto.order.OrderResponse;

import java.util.List;

public record ClientResponse(Long id,
                             String name,
                             AddressResponse address,
                             List<OrderResponse> orders) {
}
