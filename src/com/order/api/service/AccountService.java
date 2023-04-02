package com.order.api.service;

import com.order.model.Account;
import com.order.model.Meal;

import java.util.List;

public interface AccountService {
    List<Account> getAll();

    Account addAccount(String accountName, double moneyOnCard, String phoneNumber);
}
