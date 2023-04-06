package com.order.service;

import com.order.api.service.AccountService;
import com.order.api.service.MealService;
import com.order.api.service.Order;
import com.order.api.service.Wallet;
import com.order.model.Account;
import com.order.model.Meal;
import java.util.List;
import java.util.UUID;

public class OrderImpl implements Order {
    MealService meal;
    AccountService accountService;
    Wallet wallet;

    List<Meal> meals;

    Account account;

    UUID id;




    public OrderImpl(MealService mealService, AccountService accountService, Wallet wallet, UUID id){
        this.meal = mealService;
        this.accountService = accountService;
        this.wallet = wallet;
        this.id = id;
    }

    public List<Meal> getMeal(){
        return null;
    }

    public List<Meal> getAllMeals(){
        meals = meal.getAll();
        return meals;
    }

    public Account getAccount() {
        Account account = accountService.getAccount(id);
        account.setId(id);
        this.account = account;
        return account;
    }

    public void priceOfMeals(){
       // wallet.getMoneyOnCard();
    }

    @Override
    public String toString() {
        return "OrderImpl{" +
                "meal=" + meal +
                ", accountService=" + accountService +
                ", wallet=" + wallet +
                ", meals=" + meals +
                ", account=" + account +
                ", id=" + id +
                '}';
    }
}
