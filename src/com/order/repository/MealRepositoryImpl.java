package com.order.repository;

import com.order.api.repository.MealRepository;
import com.order.model.Meal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MealRepositoryImpl implements MealRepository {
    private List<Meal> meals = new ArrayList<>();

    @Override
    public Meal addMeal(Meal meal){
        meal.setId(UUID.randomUUID());
        meals.add(meal);
        return meal;
    }

    @Override
    public Meal getMeal(int index){
        return meals.get(index);
    }

    @Override
    public void deleteMealById(Long id){
        var  meal = meals.stream()
                .filter(c -> id.equals(c.getId()))
                .findFirst().
                orElseThrow(() -> new RuntimeException("Meal not found"));
        meals.remove(meal);
    }

    @Override
    public List<Meal> getAllMeal(){
        return new ArrayList<>(meals);
    }

    @Override
    public void update(Meal meal){

    }
}
