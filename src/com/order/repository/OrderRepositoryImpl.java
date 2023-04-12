package com.order.repository;

import com.order.api.repository.OrderRepository;
import com.order.model.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderRepositoryImpl implements OrderRepository {

    private List<Order> orders = new ArrayList<>();
    @Override
    public Order createOrder() {
        Order order = new Order();
        order.setId(UUID.randomUUID());
        orders.add(order);
        return order;
    }

    @Override
    public Order getOrder(UUID id) {
        var order = orders.stream().filter(c -> id.equals(c.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order not found."));
        return order;
    }

    @Override
    public void deleteOrderById(UUID id) {
        var order = orders.stream().filter(c -> id.equals(c.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order not found."));
        orders.remove(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return new ArrayList<>(orders);
    }

    @Override
    public void update(String nameOfMeal, double priceOfMeal, int cookingTime, UUID idChengingMeal) {

    }
}
