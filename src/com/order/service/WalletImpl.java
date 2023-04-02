package com.order.service;

import com.order.api.repository.AccountRepository;
import com.order.api.service.Wallet;

public class WalletImpl implements Wallet {
    @Override
    public double getMoneyOnCard(AccountRepository moneyOnCard, int index) {
        return moneyOnCard.getAccount(index).getMoneyOnCard();
    }

    @Override
    public void enrollmentMoney(AccountRepository moneyOnCard, int index, double enrollmentMoney) {
        moneyOnCard.getAccount(index).setMoneyOnCard(moneyOnCard.getAccount(index).getMoneyOnCard() + enrollmentMoney);
    }

    @Override
    public void writeOffMoneyOnCard(AccountRepository moneyOnCard, int index, double writeOffMoney) {
        moneyOnCard.getAccount(index).setMoneyOnCard(moneyOnCard.getAccount(index).getMoneyOnCard() - writeOffMoney);
    }
}
