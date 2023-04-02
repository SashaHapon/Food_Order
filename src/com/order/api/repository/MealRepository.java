package com.order.api.repository;

import com.order.model.Meal;

import java.util.List;

public interface MealRepository {

    Meal addMeal(Meal meal);

    Meal getMeal(int index);

    void deleteMealById(Long id);

    List<Meal> getAllMeal();

    void update(Meal meal);
}
