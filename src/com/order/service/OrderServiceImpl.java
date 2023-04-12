package com.order.service;

import com.order.api.service.*;
import com.order.model.Account;
import com.order.model.Meal;
import com.order.model.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {


    private MealService mealService;
    private AccountService accountService;
    private WalletService walletService;
    private OrderService orderService;

    private final ILogger LOGGER = new Logger();



    public OrderServiceImpl(AccountService accountService, OrderService orderService) throws IOException {
        //this.mealService = mealService;
        this.accountService = accountService;
        //this.walletService = walletService;
        this.orderService = orderService;
    }

    @Override
    public void addMeal(Meal meal){
        orderService.addMeal(meal);

    }

    @Override
    public List<Meal> getAllMeals(){

        return orderService.getAllMeals();
    }

    @Override
    public void setAccount(UUID id) {
        orderService.setAccount(accountService.getAccount(id).getId());
        LOGGER.info("get Account");
    }

    @Override
    public int cookingTimeSum(){
        int cookingTimeSum = 0;
        for (int i = 0; i < order.getMeals().size(); i++){
            cookingTimeSum += order.getMeals().get(i).getCookingTime();
        }
        order.setCookingTimeSum(cookingTimeSum);
        return cookingTimeSum;
    }

    @Override
    public double orderSum(){
        double orderSum = 0;
        for (int i = 0; i < order.getMeals().size(); i++){
            orderSum += order.getMeals().get(i).getPriceOfMeal();
        }
        order.setOrderSum(orderSum);
        return orderSum;
    }

    @Override
    public double applyDiscount(String discount){
        double discountPrise = order.getOrderSum();
        discountPrise *= Double.parseDouble(discount);
        order.setOrderSum(discountPrise);
        return discountPrise;
    }

    @Override
    public void checkPayment() throws MyException {

        try {
            if (order.getOrderSum() > accountService.getAccount(order.getAccount().getId()).getMoneyOnCard()) throw new MyException("Not enought money", 1);
        } catch (MyException e){
            System.out.println(e.getNumber());
            LOGGER.info("no honey");
        }
    }

}
