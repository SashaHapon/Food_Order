package com.order.api.repository;
import com.order.model.Order;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface OrderRepository {
    Order createOrder(Order order) throws SQLException;
    Order getOrder(UUID id);
    void deleteOrderById(UUID id);
    List<Order> getAllOrder();
    void update(String nameOfMeal, double priceOfMeal, int cookingTime, UUID idChengingMeal);
}
