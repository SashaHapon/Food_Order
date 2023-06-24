package com.order.repository;

import com.order.api.repository.MealRepository;
import com.order.model.Meal;
import com.order.utils.ConnectionManager;
import com.order.utils.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class MealRepositoryImpl implements MealRepository {
    private final ConnectionManager connectionManager = ConnectionManager.getInstance();

    @Override
    public Meal addMeal(Meal meal){
        var connection = connectionManager.getConnection();
        var query = "INSERT meal(id, name, price, time, date) VALUES(?,?,?,?,?)";
        try(var statement  = connection.prepareStatement(query)){
            statement.setString(1, String.valueOf(UUID.randomUUID()));
            statement.setString(2, meal.getName());
            statement.setString(3, String.valueOf(meal.getPrice()));
            statement.setString(4, String.valueOf(meal.getTime()));
            statement.setString(5, "10/10/2022");
            statement.executeUpdate();
            return meal;
        }catch (SQLException e){

            throw new RuntimeException(e);
        }
    }

    @Override
    public Meal getMeal(UUID id){
        var query = "select * from meal where idMeal = ?";
        var connection = connectionManager.getConnection();
        try(var statement = connection.prepareStatement(query)) {
            statement.setString(1, String.valueOf(id));
            var resultSet = statement.executeQuery();
            Mapper mapper = new Mapper();
            return mapper.getMeal(resultSet);
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteMealById(UUID id){
        var connection = connectionManager.getConnection();
        var query = "DELETE FROM meal WHERE idMeal = ?";
        try(var statement  = connection.prepareStatement(query)){
            statement.setString(1, String.valueOf(id));
            statement.executeUpdate();
        }catch (SQLException e){

            System.out.println("Can't delete meal: " + e.getMessage());
        }
    }

    @Override
    public List<Meal> getAllMeal(){

        var connection = connectionManager.getConnection();
        var query = "SELECT * FROM meal";
        try(var statement  = connection.prepareStatement(query)){
            var resultSet = statement.executeQuery();
            Mapper mapper = new Mapper();
            return mapper.getMeals(resultSet);
        }catch (SQLException e){

            System.out.println("Can't delete account: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(String nameOfMeal, double priceOfMeal, int cookingTime, String idChengingMeal) {
        var connection = connectionManager.getConnection();
        try (var statement = connection.prepareStatement("UPDATE meal SET nameOfMeal = ?, priceOfMeal = ?, cookingTime = ? WHERE idAccount = ?")) {
            statement.setString(1, nameOfMeal);
            statement.setString(2, String.valueOf(priceOfMeal));
            statement.setString(3, String.valueOf(cookingTime));
            statement.setString(3, idChengingMeal);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        }
    }