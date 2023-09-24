package br.edu.ifsp.restaurante.repository;

import br.edu.ifsp.restaurante.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
