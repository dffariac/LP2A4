package br.edu.ifsp.restaurante.mapper.address;

import br.edu.ifsp.restaurante.dto.address.AddressRequest;
import br.edu.ifsp.restaurante.dto.address.AddressResponse;
import br.edu.ifsp.restaurante.model.Address;

public class AddressMapper {
    public static AddressResponse addressToResponse(Address address) {
        return new AddressResponse(address.getId(), address.getStreet(), address.getCity());
    }

    public static Address requestToAddress(AddressRequest request) {
        Address address = new Address();
        address.setStreet(request.street());
        address.setCity(request.city());
        return address;
    }

    public static Address responseToAddress(AddressResponse response) {
        Address address = new Address();
        address.setId(response.id());
        address.setStreet(response.street());
        address.setCity(response.city());
        return address;
    }
}
