package com.order.api.service;
import com.order.model.Account;
import com.order.model.Meal;
import com.order.model.Order;
import com.order.service.MyException;
import java.util.List;
import java.util.UUID;

public interface OrderService {

    Order createOrder();

    void addMeal(Meal meal, UUID idOrder);

    List<Meal> getAllMeals(UUID idOrder);

    void setAccount(UUID idOrder, Account account);

    int cookingTimeSum(UUID idOrder);

    double orderSum(UUID idOrder);

    double applyDiscount(String discount, UUID idOrder);

    void checkPayment(UUID idOrder) throws MyException;
}
