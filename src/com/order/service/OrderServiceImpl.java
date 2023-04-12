package com.order.service;

import com.order.api.repository.OrderRepository;
import com.order.api.service.*;
import com.order.model.Account;
import com.order.model.Meal;
import com.order.model.Order;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {


    private MealService mealService;
    private AccountService accountService;
    private WalletService walletService;
    private OrderService orderService;

    OrderRepository orderRepository;

    private final ILogger LOGGER = new Logger();



    public OrderServiceImpl(OrderRepository orderRepository) throws IOException {
        this.orderRepository= orderRepository;
    }

    @Override
    public Order createOrder(){
        return orderRepository.createOrder();
    }

    @Override
    public void addMeal(Meal meal, UUID idOrder){
        orderRepository.getOrder(idOrder).addMeal(meal);
    }

    @Override
    public List<Meal> getAllMeals(UUID idOrder){
        return orderRepository.getOrder(idOrder).getMeals();
    }

    @Override
    public void setAccount(UUID idOrder, Account account) {
        orderRepository.getOrder(idOrder).setAccount(account);
        LOGGER.info("get Account");
    }

    @Override
    public int cookingTimeSum(UUID idOrder){
        int cookingTimeSum = 0;
        for (int i = 0; i < orderRepository.getOrder(idOrder).getMeals().size(); i++){
            cookingTimeSum += orderRepository.getOrder(idOrder).getMeals().get(i).getCookingTime();
        }
        orderRepository.getOrder(idOrder).setCookingTimeSum(cookingTimeSum);
        return cookingTimeSum;
    }

    @Override
    public double orderSum(UUID idOrder){
        double orderSum = 0;
        for (int i = 0; i < orderRepository.getOrder(idOrder).getMeals().size(); i++){
            orderSum += orderRepository.getOrder(idOrder).getMeals().get(i).getPriceOfMeal();
        }
        orderRepository.getOrder(idOrder).setOrderSum(orderSum);
        return orderSum;
    }

    @Override
    public double applyDiscount(String discount, UUID idOrder){
        double discountPrise = orderRepository.getOrder(idOrder).getOrderSum();
        discountPrise *= Double.parseDouble(discount);
        orderRepository.getOrder(idOrder).setOrderSum(discountPrise);
        return discountPrise;
    }

    @Override
    public void checkPayment(UUID idOrder) throws MyException {

        try {
            if (orderRepository.getOrder(idOrder).getOrderSum() > orderRepository.getOrder(idOrder).getAccount().getMoneyOnCard()) throw new MyException("Not enought money", 1);
        } catch (MyException e){
            System.out.println(e.getNumber());
            LOGGER.info("no honey");
        }
    }

}
