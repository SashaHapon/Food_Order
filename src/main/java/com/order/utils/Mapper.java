package com.order.utils;

import com.order.api.service.AccountService;
import com.order.api.service.OrderService;
import com.order.model.Account;
import com.order.model.Meal;
import com.order.model.Order;
import com.order.repository.AccountRepositoryImpl;
import com.order.service.AccountServiceImpl;

import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Mapper {
    private ResultSet resultSet;
    private Statement statement;
    public Mapper(ResultSet resultSet){
        this.resultSet = resultSet;
    }

    AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
    AccountService accountService = new AccountServiceImpl(accountRepository);

    public Account getAccount() throws SQLException {
        Account account = new Account();
        resultSet.next();
        account.setId(resultSet.getLong("idAccount"));
        account.setAccountName(resultSet.getString("accountName"));
        account.setPhoneNumber(resultSet.getString("phoneNumber"));
        return account;
    }

    public List<Account> getAccounts() throws  SQLException{
        int j = 1;
        List <Account> array = new ArrayList<>();
        while (resultSet.next()){
            Account account = new Account();
            account.setId(resultSet.getLong("idAccount"));
            account.setAccountName(resultSet.getString("accountName"));
            account.setPhoneNumber(resultSet.getString("phoneNumber"));
            array.add(account);
            j++;
        }
        return array;
    }

    public Meal getMeal() throws SQLException {
        Meal meal = new Meal();
        resultSet.next();
        meal.setId(resultSet.getLong("idMeal"));
        meal.setNameOfMeal(resultSet.getString("nameOfMeal"));
        meal.setPriceOfMeal(resultSet.getDouble("priceOfMeal"));
        meal.setCookingTime(resultSet.getInt("cookingTime"));
        meal.setCreateDate(resultSet.getString("createDate"));

        return meal;
    }

    public List<Meal> getMeals() throws SQLException {
        int j = 1;
        List <Meal> array = new ArrayList<>();
        while (resultSet.next()){
            Meal meal = new Meal();
            meal.setId(Long.getLong(resultSet.getString("idMeal")));    //?????
            meal.setNameOfMeal(resultSet.getString("nameOfMeal"));
            meal.setPriceOfMeal(resultSet.getDouble("priceOfMeal"));
            meal.setCookingTime(resultSet.getInt("cookingTime"));
            meal.setCreateDate(resultSet.getString("createDate"));
            array.add(meal);
            j++;
        }
        return array;
    }

    public Order getOrder() {

        try {
            Order order = new Order();
            resultSet.next();
            order.setIdw(resultSet.getString("idOrderRepository"));     //?? can't get Long
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
