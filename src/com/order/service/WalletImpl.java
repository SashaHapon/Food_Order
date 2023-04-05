package com.order.service;

import com.order.api.repository.AccountRepository;
import com.order.api.service.Wallet;

import java.util.UUID;

public class WalletImpl implements Wallet {
    @Override
    public double getMoneyOnCard(AccountRepository moneyOnCard, UUID id) {
        return moneyOnCard.getAccount(id).getMoneyOnCard();
    }

    @Override
    public void enrollmentMoney(AccountRepository moneyOnCard, UUID id, double enrollmentMoney) {
        moneyOnCard.getAccount(id).setMoneyOnCard(moneyOnCard.getAccount(id).getMoneyOnCard() + enrollmentMoney);
    }

    @Override
    public void writeOffMoneyOnCard(AccountRepository moneyOnCard, UUID id, double writeOffMoney) {
        moneyOnCard.getAccount(id).setMoneyOnCard(moneyOnCard.getAccount(id).getMoneyOnCard() - writeOffMoney);
    }
}
