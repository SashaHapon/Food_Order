package com.order.service;
import com.order.api.service.AccountService;
import com.order.api.service.MealService;
import com.order.api.service.Order;
import com.order.api.service.Wallet;
import com.order.model.Account;
import com.order.model.Meal;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderImpl implements Order {
    private MealService mealService;
    private AccountService accountService;
    private Wallet walletService;

    private List<Meal> meals = new ArrayList<>();
    private Account account;
    private UUID id;
    private double orderSum;
    private int cookingTimeSum;




    public OrderImpl(MealService mealService, AccountService accountService, Wallet wallet, UUID id){
        this.mealService = mealService;
        this.accountService = accountService;
        this.walletService = wallet;
        this.id = id;
    }

    @Override
    public void addMeal(Meal meal){
        meals.add(meal);
    }

    @Override
    public List<Meal> getAllMeals(){
        return meals;
    }

    @Override
    public void setAccount(UUID  id) {
        this.account = accountService.getAccount(id);
    }

    @Override
    public int cookingTimeSum(){
        for (int i = 0; i < meals.size(); i++){
            cookingTimeSum += meals.get(i).getCookingTime();
        }
        return cookingTimeSum;
    }

    @Override
    public double orderSum(){
        for (int i = 0; i < meals.size(); i++){
            orderSum += meals.get(i).getPriceOfMeal();
        }
       return orderSum;
    }

    @Override
    public double applyDiscount(String discount){
        orderSum *= Double.parseDouble(discount);
        return orderSum;
    }

    @Override
    public boolean checkPayment(){
        if (orderSum < accountService.getAccount(id).getMoneyOnCard()){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "OrderImpl{" +
                "meal=" + mealService +
                ", accountService=" + accountService +
                ", wallet=" + walletService +
                ", meals=" + meals +
                ", account=" + account +
                ", id=" + id +
                '}';
    }
}
