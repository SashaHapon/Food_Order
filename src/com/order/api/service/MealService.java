package com.order.api.service;

import com.order.model.Meal;

import java.util.List;
import java.util.UUID;

public interface MealService {
    List<Meal> getAll();

    Meal addMeal(String nameOfMeal, double priceOfMeal, int cookingTime);

    Meal getMeal(UUID id);

    void deleteMealById(UUID id);

    void update(String nameOfMeal, double priceOfMeal, int cookingTime, UUID idChengingMeal);
}
