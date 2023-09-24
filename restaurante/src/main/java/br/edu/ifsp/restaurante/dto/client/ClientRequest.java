package br.edu.ifsp.restaurante.dto.client;

import br.edu.ifsp.restaurante.dto.address.AddressResponse;

public record ClientRequest(String name,
                            AddressResponse address) {
}
