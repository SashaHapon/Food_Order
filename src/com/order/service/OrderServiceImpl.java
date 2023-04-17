package com.order.service;

import com.order.api.repository.OrderRepository;
import com.order.api.service.ILogger;
import com.order.api.service.OrderService;
import com.order.model.Account;
import com.order.model.Meal;
import com.order.model.Order;

import java.util.List;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {

    private static final ILogger LOGGER = new Logger();
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository= orderRepository;
    }

    @Override
    public Order createOrder(Account account, List<Meal> meals) {
        var order = new Order();
        order.setAccount(account);
        order.setMeals(meals);
        orderSum(order);
        cookingTimeSum(order);
        orderRepository.createOrder(order);
        return order;
    }

    @Override
    public void addMeal(Meal meal, UUID idOrder){
        var order = orderRepository.getOrder(idOrder);
        order.getMeals().add(meal);
        order.setOrderSum(order.getOrderSum() + meal.getPriceOfMeal());
        order.setCookingTimeSum(order.getCookingTimeSum() + meal.getCookingTime());
    }

    @Override
    public void remove(Meal meal, UUID idOrder){
        var order = orderRepository.getOrder(idOrder);
        order.getMeals().remove(meal);
        order.setCookingTimeSum(order.getCookingTimeSum() - meal.getCookingTime());
    }

    @Override
    public List<Meal> getAllMeals(UUID idOrder){

        return orderRepository.getOrder(idOrder).getMeals();
    }

    private int cookingTimeSum(Order order){
        int cookingTimeSum = 0;
        for (Meal meal : order.getMeals()) {
            cookingTimeSum += meal.getCookingTime();
        }
        order.setCookingTimeSum(cookingTimeSum);
        return cookingTimeSum;
    }

    private double orderSum(Order order){
        double orderSum = 0;
        for (int i = 0; i < order.getMeals().size(); i++){
            orderSum += order.getMeals().get(i).getPriceOfMeal();
        }
        order.setOrderSum(orderSum);
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
            if (orderRepository.getOrder(idOrder).getOrderSum() > orderRepository.getOrder(idOrder)
                    .getAccount()
                    .getMoneyOnCard())
                     throw new MyException("Not enought money", 1);

    }

}
