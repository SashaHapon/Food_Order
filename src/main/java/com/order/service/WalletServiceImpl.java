package com.order.service;
import com.order.api.service.AccountService;
import com.order.api.service.WalletService;

import java.util.UUID;

public class WalletServiceImpl implements WalletService {

    private final AccountService accountService;
    public WalletServiceImpl(AccountService accountService){
        this.accountService = accountService;
    }

    @Override
    public double enrollmentMoney(UUID idAccount, double enrollmentMoney) {
        accountService.getAccount(idAccount).setMoney(accountService.getAccount(idAccount).getMoney() + enrollmentMoney);
        return enrollmentMoney;
    }

    @Override
    public double writeOffMoneyOnCard(UUID idAccount, double writeOffMoney) {
        accountService.getAccount(idAccount).setMoney(accountService.getAccount(idAccount).getMoney() - writeOffMoney);
        return writeOffMoney;
    }
}
