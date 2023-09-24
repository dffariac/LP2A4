package br.edu.ifsp.restaurante.dto.meal;

public record MealRequest(String name,
                          String description,
                          Double price) {
}
