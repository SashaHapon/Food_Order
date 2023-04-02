package com.order.api.service;

import com.order.model.Meal;

import java.util.List;

public interface MealService {
    List<Meal> getAll();

    Meal addMeal(String nameOfMeal, double priceOfMeal, int cookingTime);
}
