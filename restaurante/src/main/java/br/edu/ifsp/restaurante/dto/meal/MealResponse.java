package br.edu.ifsp.restaurante.dto.meal;

public record MealResponse(Long id,
                           String name,
                           String description,
                           Double price) {
}
