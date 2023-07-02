package com.order.utils;

import com.order.model.Account;
import com.order.model.Meal;
import com.order.model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Mapper {
    private ResultSet resultSet;
    public Account getAccount(ResultSet resultSet) throws SQLException {
        this.resultSet = resultSet;
        Account account = new Account();
        resultSet.next();
        account.setId(resultSet.getString("idAccount"));
        account.setName(resultSet.getString("accountName"));
        account.setPhoneNumber(resultSet.getString("phoneNumber"));
        return account;
    }

    public List<Account> getAccounts(ResultSet resultSet) throws  SQLException{
        this.resultSet = resultSet;
        int j = 1;
        List <Account> array = new ArrayList<>();
        while (resultSet.next()){
            Account account = new Account();
            account.setId(resultSet.getString("idAccount"));
            account.setName(resultSet.getString("accountName"));
            account.setPhoneNumber(resultSet.getString("phoneNumber"));
            array.add(account);
            j++;
        }
        return array;
    }

    public Meal getMeal(ResultSet resultSet) throws SQLException {
        this.resultSet = resultSet;
        Meal meal = new Meal();
        resultSet.next();
        meal.setId(resultSet.getString("idMeal"));
        meal.setName(resultSet.getString("nameOfMeal"));
        meal.setPrice(resultSet.getDouble("priceOfMeal"));
        meal.setTime(resultSet.getInt("cookingTime"));
        meal.setDate(resultSet.getString("createDate"));

        return meal;
    }

    public List<Meal> getMeals(ResultSet resultSet) throws SQLException {
        this.resultSet = resultSet;
        int j = 1;
        List <Meal> array = new ArrayList<>();
        while(resultSet.next()) {
            Meal meal = new Meal();
            meal.setId(resultSet.getString("idMeal"));    //?????
            meal.setName(resultSet.getString("nameOfMeal"));
            meal.setPrice(resultSet.getDouble("priceOfMeal"));
            meal.setTime(resultSet.getInt("cookingTime"));
            meal.setDate(resultSet.getString("createDate"));
            array.add(meal);
            j++;
        }
        return array;
    }

    public Order getOrder(ResultSet resultSet) {
        this.resultSet = resultSet;
        try {
            Order order = new Order();
            resultSet.next();
            order.setId(resultSet.getString("idOrderRepository"));     //?? can't get Long
            order.setCookingTimeSum(resultSet.getInt("cookingTimeSum"));
            order.setOrderSum(Double.parseDouble(resultSet.getString("orderSum")));




            order.setAccountId(resultSet.getString("account")); // need use id from account Table(1: createOrder(account id ))
          //  order.setMeals(resultSet.getString("listOfMeals"));

            return order;
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }
}
