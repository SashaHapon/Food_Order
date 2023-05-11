package com.order.utils;

import com.order.model.Account;
import com.order.model.Meal;

import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Mapper {
    private ResultSet resultSet;
    private Statement statement;
    public Mapper(ResultSet resultSet){
        this.resultSet = resultSet;
    }

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
}
