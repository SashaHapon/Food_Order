package com.order.api.service;

import com.order.model.Account;
import com.order.model.Meal;

import java.util.List;
import java.util.UUID;

public interface AccountService {
    List<Account> getAll();

    Account addAccount(String accountName, double moneyOnCard, String phoneNumber);

    Account getAccount(UUID id);

    void deleteAccountById(UUID id);

    void update(String name, String phone, UUID idChengingAccount);
 }
