package br.edu.ifsp.restaurante.controller;

import br.edu.ifsp.restaurante.dto.meal.MealRequest;
import br.edu.ifsp.restaurante.dto.meal.MealResponse;
import br.edu.ifsp.restaurante.mapper.meal.MealMapper;
import br.edu.ifsp.restaurante.model.Meal;
import br.edu.ifsp.restaurante.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MealService mealService;

    @GetMapping
    public ResponseEntity<List<MealResponse>> showAll(){
        List<MealResponse> response = this.mealService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MealResponse> createMeal(@RequestBody MealRequest request) {
        MealResponse response = this.mealService.save(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{mealId}")
    public ResponseEntity<MealResponse> editMeal(@PathVariable Long mealId, @RequestBody MealRequest request) {
        Meal meal = MealMapper.responseToMeal(this.mealService.findById(mealId));
        meal.setName(request.name());
        meal.setDescription(request.description());
        meal.setPrice(request.price());
        MealResponse response = this.mealService.save(meal);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{mealId}")
    public ResponseEntity<Void> deleteMeal(@PathVariable Long mealId) {
        this.mealService.deleteById(mealId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
