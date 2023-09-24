package br.edu.ifsp.restaurante.mapper.meal;

import br.edu.ifsp.restaurante.dto.meal.MealRequest;
import br.edu.ifsp.restaurante.dto.meal.MealResponse;
import br.edu.ifsp.restaurante.model.Meal;

public class MealMapper {
    public static MealResponse mealToResponse(Meal meal) {
        return new MealResponse(meal.getId(), meal.getName(), meal.getDescription(), meal.getPrice());
    }

    public static Meal requestToMeal(MealRequest request) {
        Meal meal = new Meal();
        meal.setName(request.name());
        meal.setPrice(request.price());
        meal.setDescription(request.description());
        return meal;
    }

    public static Meal responseToMeal(MealResponse response) {
        Meal meal = new Meal();
        meal.setId(response.id());
        meal.setName(response.name());
        meal.setDescription(response.description());
        meal.setPrice(response.price());
        return meal;
    }
}
