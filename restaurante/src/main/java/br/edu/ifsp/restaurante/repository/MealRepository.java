package br.edu.ifsp.restaurante.repository;

import br.edu.ifsp.restaurante.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
}
