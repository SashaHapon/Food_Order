package com.order.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order", schema = "mydb")
public class Order {
    @Id
    private Long id;
    private List<Meal> meals = new ArrayList<>();
    private Account account;
    private String accountId;
    private String idw;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }



    public String getIdw() {
        return idw;
    }

    public void setIdw(String idw) {
        this.idw = idw;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
