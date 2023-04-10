package com.order.service;

import com.order.api.service.*;
import com.order.model.Account;
import com.order.model.Meal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {


    private MealService mealService;
    private AccountService accountService;
    private WalletService walletService;

    private List<Meal> meals = new ArrayList<>();
    private Account account;
    private UUID id;
    private double orderSum;
    private int cookingTimeSum;
    ILogger logger = new Logger();




    public OrderServiceImpl(MealService mealService, AccountService accountService, WalletService wallet, UUID id) throws IOException {
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
    public void setAccount(UUID id) {
        this.account = accountService.getAccount(id);
        logger.info("get Account");
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
    public void checkPayment() throws Exception, IOException {

        try {
            if (orderSum > accountService.getAccount(id).getMoneyOnCard()) throw new Exception("Not enought money", 1);
        } catch (Exception e){
            System.out.println(e.getNumber());
            logger.info("no honey");

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
