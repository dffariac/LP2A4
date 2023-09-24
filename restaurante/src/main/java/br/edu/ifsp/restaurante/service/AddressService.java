package br.edu.ifsp.restaurante.service;

import br.edu.ifsp.restaurante.dto.address.AddressRequest;
import br.edu.ifsp.restaurante.dto.address.AddressResponse;
import br.edu.ifsp.restaurante.mapper.address.AddressMapper;
import br.edu.ifsp.restaurante.model.Address;
import br.edu.ifsp.restaurante.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public List<AddressResponse> findAll(){
        return this.addressRepository.findAll().stream().map(AddressMapper::addressToResponse).toList();
    }

    public AddressResponse findById(Long id){
        return this.addressRepository.findById(id).map(AddressMapper::addressToResponse)
                .orElseThrow(() -> new RuntimeException("address #"+id+" not found"));
    }

    public AddressResponse save(AddressRequest request){
        Address address = this.addressRepository.save(AddressMapper.requestToAddress(request));
        return AddressMapper.addressToResponse(address);
    }

    public AddressResponse save(Address address){
        return AddressMapper.addressToResponse(this.addressRepository.save(address));
    }

    public void deleteById(Long id){
        this.addressRepository.deleteById(id);
    }
}
