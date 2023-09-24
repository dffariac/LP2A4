package br.edu.ifsp.restaurante.repository;

import br.edu.ifsp.restaurante.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
