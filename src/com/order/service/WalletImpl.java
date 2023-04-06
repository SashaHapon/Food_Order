package com.order.service;
import com.order.api.repository.AccountRepository;
import com.order.api.service.AccountService;
import com.order.api.service.Wallet;
import com.order.model.Meal;

import java.util.List;
import java.util.UUID;

public class WalletImpl implements Wallet {

    private double orderSum;
    private double moneyOnCard;
    @Override
    public double getMoneyOnCard(AccountService accountService, UUID id) {
        this.moneyOnCard = accountService.getAccount(id).getMoneyOnCard();
        return moneyOnCard;

    }

    @Override
    public double orderSum(List<Meal> mealService) {
        orderSum = 0;
        for (int i = 0; i < mealService.size(); i++) {
            orderSum += mealService.get(i).getPriceOfMeal();
        }
        return orderSum;
    }

    public boolean checkMoney(){
        if( moneyOnCard > orderSum){
            System.out.println("Ok.");
            return true;
        } else {
            System.out.println("Does't have money.");
            return false;
        }

    }

    @Override
    public double enrollmentMoney(AccountService accountService, UUID id, double enrollmentMoney) {
        accountService.getAccount(id).setMoneyOnCard(accountService.getAccount(id).getMoneyOnCard() + enrollmentMoney);
        return enrollmentMoney;
    }

    @Override
    public double writeOffMoneyOnCard(AccountService accountService, UUID id, double writeOffMoney) {
        accountService.getAccount(id).setMoneyOnCard(accountService.getAccount(id).getMoneyOnCard() - writeOffMoney);
        return writeOffMoney;
    }
}
