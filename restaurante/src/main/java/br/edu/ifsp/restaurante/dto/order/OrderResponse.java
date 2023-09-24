package br.edu.ifsp.restaurante.dto.order;

import br.edu.ifsp.restaurante.dto.meal.MealResponse;

import java.util.List;

public record OrderResponse(Long id,
                            String description,
                            Long client,
                            List<MealResponse> meals) {
}
