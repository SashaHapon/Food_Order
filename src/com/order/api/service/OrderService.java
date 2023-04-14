package com.order.api.service;
import com.order.model.Account;
import com.order.model.Meal;
import com.order.model.Order;
import com.order.service.MyException;
import java.util.List;
import java.util.UUID;

public interface OrderService {

    Order createOrder(Account account, List<Meal> meals);

    void addMeal(Meal meal, UUID idOrder);

    void remove(Meal meal, UUID idOrder);

    List<Meal> getAllMeals(UUID idOrder);

    double applyDiscount(String discount, UUID idOrder);

    void checkPayment(UUID idOrder) throws MyException;
}
