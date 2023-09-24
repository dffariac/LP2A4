package br.edu.ifsp.restaurante.service;

import br.edu.ifsp.restaurante.dto.meal.MealRequest;
import br.edu.ifsp.restaurante.dto.meal.MealResponse;
import br.edu.ifsp.restaurante.mapper.meal.MealMapper;
import br.edu.ifsp.restaurante.model.Meal;
import br.edu.ifsp.restaurante.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealService {

    private final MealRepository mealRepository;

    public List<MealResponse> findAll(){
        return this.mealRepository.findAll().stream().map(MealMapper::mealToResponse).toList();
    }

    public MealResponse findById(Long id){
        return this.mealRepository.findById(id).map(MealMapper::mealToResponse)
                .orElseThrow(() -> new RuntimeException("meal #"+id+" not found"));
    }

    public MealResponse save(MealRequest request){
        Meal meal = this.mealRepository.save(MealMapper.requestToMeal(request));
        return MealMapper.mealToResponse(meal);
    }

    public MealResponse save(Meal meal){
        return MealMapper.mealToResponse(this.mealRepository.save(meal));
    }

    public void deleteById(Long id){
        this.mealRepository.deleteById(id);
    }

}
