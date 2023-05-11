package com.order.repository;

import com.order.api.repository.OrderRepository;
import com.order.model.Order;
import com.order.utils.ConnectionManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderRepositoryImpl implements OrderRepository {

    ConnectionManager connectionManager = ConnectionManager.getInstance();
    private List<Order> orders = new ArrayList<>();
    @Override
    public Order createOrder(Order order) throws SQLException {
        var connection = connectionManager.getConnection();
        var query = "INSERT orderrepository() VALUES()";
        try(var statement = connection.prepareStatement(query)){

        }catch (RuntimeException e){

        }
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
