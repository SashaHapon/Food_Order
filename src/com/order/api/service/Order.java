package com.order.api.service;

import com.order.model.Meal;

import java.util.List;
import java.util.UUID;

public interface Order {
    void addMeal(Meal meal);

    List<Meal> getAllMeals();

    void setAccount(UUID id);

    int cookingTimeSum();

    double orderSum();

    double applyDiscount(String discount);

    boolean checkPayment();
}
