package com.order.service;
import com.order.api.service.AccountService;
import com.order.api.service.Wallet;

import java.util.UUID;

public class WalletServiceImpl implements Wallet {

    private AccountService accountService;
    public WalletServiceImpl(AccountService accountService){
        this.accountService = accountService;
    }

    @Override
    public double enrollmentMoney(UUID id, double enrollmentMoney) {
        accountService.getAccount(id).setMoneyOnCard(accountService.getAccount(id).getMoneyOnCard() + enrollmentMoney);
        return enrollmentMoney;
    }

    @Override
    public double writeOffMoneyOnCard(UUID id, double writeOffMoney) {
        accountService.getAccount(id).setMoneyOnCard(accountService.getAccount(id).getMoneyOnCard() - writeOffMoney);
        return writeOffMoney;
    }
}
