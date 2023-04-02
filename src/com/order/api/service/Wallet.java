package com.order.api.service;

import com.order.api.repository.AccountRepository;

public interface Wallet {
    double getMoneyOnCard(AccountRepository getMoneyOnCard, int index);
    void enrollmentMoney(AccountRepository moneyOnCard, int index, double enrollmentMoney);
    void writeOffMoneyOnCard(AccountRepository moneyOnCard, int index, double writeOffMoney);
}
