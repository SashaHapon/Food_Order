package com.order.api.repository;
import com.order.model.Meal;

import java.util.List;
import java.util.UUID;

public interface MealRepository {

    Meal addMeal(Meal meal);
    Meal getMeal(UUID id);
    void deleteMealById(UUID id);
    List<Meal> getAllMeal();
    void update(String nameOfMeal, double priceOfMeal, int cookingTime, String idChengingMeal);
}
