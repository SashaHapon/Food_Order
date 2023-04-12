package com.order.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    private List<Meal> meals = new ArrayList<>();
    private Account account;
    private UUID id;
    private double orderSum;
    private int cookingTimeSum;

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(double orderSum) {
        this.orderSum = orderSum;
    }

    public int getCookingTimeSum() {
        return cookingTimeSum;
    }

    public void setCookingTimeSum(int cookingTimeSum) {
        this.cookingTimeSum = cookingTimeSum;
    }

    @Override
    public String toString() {
        return "Order{" +
                "meals=" + meals +
                ", account=" + account +
                ", id=" + id +
                ", orderSum=" + orderSum +
                ", cookingTimeSum=" + cookingTimeSum +
                '}';
    }
}
