package com.order.api.service;

import com.order.model.Meal;
import com.order.service.Exception;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface OrderService {
    void addMeal(Meal meal);

    List<Meal> getAllMeals();

    void setAccount(UUID id);

    int cookingTimeSum();

    double orderSum();

    double applyDiscount(String discount);

    void checkPayment() throws Exception, IOException;
}
