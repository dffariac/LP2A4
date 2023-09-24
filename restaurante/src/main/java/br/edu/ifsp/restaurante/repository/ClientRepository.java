package br.edu.ifsp.restaurante.repository;

import br.edu.ifsp.restaurante.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
