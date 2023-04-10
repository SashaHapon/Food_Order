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
    private MealService mealService;
    private AccountService accountService;
    private Wallet walletService;

    List<Meal> meals;
    Account account;
    UUID id;
    private Double orderSum;




    public OrderImpl(MealService mealService, AccountService accountService, Wallet wallet, UUID id){
        this.mealService = mealService;
        this.accountService = accountService;
        this.walletService = wallet;
        this.id = id;
    }

    public Meal addMeal(Meal meal){
        meals.add(meal);
        return meal;
    }

    public List<Meal> getAllMeals(){
        return meals;
    }

    public Account setAccount() {
        Account account = accountService.getAccount(id);
        this.account = account;
        return account;
    }

    public double orderSum(){
        for (int i = 0; i < meals.size(); i++){
            orderSum += meals.get(i).getPriceOfMeal();
        }
       return orderSum;
    }
    public boolean checkPayment(){
        if (orderSum > accountService.getAccount(id).getMoneyOnCard()){
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
