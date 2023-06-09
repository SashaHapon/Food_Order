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
    public Meal getMeal(UUID id){
        var meal = meals.stream().filter(c -> id.equals(c.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return meal;

    }

    @Override
    public void deleteMealById(UUID id){
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
    public void update(String nameOfMeal, double priceOfMeal, int cookingTime, UUID idChengingMeal) {
        var meal = meals.stream().filter(c -> idChengingMeal.equals(c.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Meal not found"));
        meal.setNameOfMeal(nameOfMeal);
        meal.setPriceOfMeal(priceOfMeal);
        meal.setCookingTime(cookingTime);
        }
    }