package com.order.api.service;

import com.order.api.repository.AccountRepository;
import com.order.model.Meal;

import java.util.List;
import java.util.UUID;

public interface Wallet {
    double getMoneyOnCard(AccountService accountService, UUID id);

    double orderSum(List<Meal> mealService);

    double enrollmentMoney(AccountService accountService, UUID id, double enrollmentMoney);
    double writeOffMoneyOnCard(AccountService accountService, UUID id, double writeOffMoney);
}
