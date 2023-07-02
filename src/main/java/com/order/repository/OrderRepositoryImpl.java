package com.order.repository;

import com.order.api.repository.OrderRepository;
import com.order.model.Order;
import com.order.service.MyException;
import com.order.utils.Mapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.order.utils.ConnectionManager.getConnection;

public class OrderRepositoryImpl implements OrderRepository {

 //   ConnectionManager connectionManager = ConnectionManager.getInstance();
    private List<Order> orders = new ArrayList<>();
    @Override
    public Order createOrder(Order order) throws SQLException {
        var connection = getConnection();
        var query = "INSERT orderrepository (idOrderRepository, listOfMeals, account, orderSum, cookingTimeSum, Meal_idMeal, Account_idAccount) VALUES(?,?,?,?,?,?,?)";

        try(var statement = connection.prepareStatement(query)){
            statement.setString(1, String.valueOf(UUID.randomUUID()));
            statement.setString(2, order.getMeals().toString());            //???
            statement.setString(3, String.valueOf(order.getAccount().getId()));
            statement.setDouble(4, order.getOrderSum());
            statement.setInt(5, order.getCookingTimeSum());
            statement.setString(6, "1");
            statement.setString(7,"1");
            statement.executeUpdate();
            return  order;
        }catch (RuntimeException e){

            throw new MyException(e.getMessage() + ": Can't create order");
        }
    }

    @Override
    public Order getOrder(UUID id) {
        var query = "select * from orderrepository where idOrderRepository = ?";
        var connection = getConnection();
        try(var statement = connection.prepareStatement(query)) {
            statement.setString(1, String.valueOf(id));
            var resultSet = statement.executeQuery();
            Mapper mapper = new Mapper();
            Order order = mapper.getOrder(resultSet);

            return order;
        } catch (SQLException e) {

            throw new MyException(e.getMessage() + ": Can't get order");
        }
    }

    @Override
    public void deleteOrderById(UUID id) {
        var order = orders.stream().filter(c -> id.equals(c.getId()))
                .findFirst()
                .orElseThrow(() -> new MyException("Order not found."));
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
