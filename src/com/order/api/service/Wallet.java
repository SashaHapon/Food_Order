package com.order.api.service;

import com.order.api.repository.AccountRepository;

import java.util.UUID;

public interface Wallet {
    double getMoneyOnCard(AccountRepository getMoneyOnCard, UUID id);
    void enrollmentMoney(AccountRepository moneyOnCard, UUID id, double enrollmentMoney);
    void writeOffMoneyOnCard(AccountRepository moneyOnCard, UUID id, double writeOffMoney);
}
