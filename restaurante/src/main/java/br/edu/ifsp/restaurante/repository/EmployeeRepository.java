package br.edu.ifsp.restaurante.repository;

import br.edu.ifsp.restaurante.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
