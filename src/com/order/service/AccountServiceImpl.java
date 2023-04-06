package com.order.service;
import com.order.api.service.AccountService;
import com.order.api.service.Wallet;
import com.order.model.Account;
import com.order.api.repository.AccountRepository;
import java.util.List;
import java.util.UUID;

public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository; }
    @Override
    public List<Account> getAll() {
        return accountRepository.getAllAccounts();
    }

    @Override
    public Account addAccount(String accountName, double moneyOnCard, String phoneNumber) {
        return accountRepository.addAccount(new Account(accountName, moneyOnCard, phoneNumber));
    }
    @Override
    public Account getAccount(UUID id){
        return accountRepository.getAccount(id);
    }
    @Override
    public void deleteAccountById(UUID id){
        accountRepository.deleteAccountById(id);
    }
    @Override
    public void update(String name, String phone, UUID idChengingAccount){
       accountRepository.update(name, phone, idChengingAccount);

    }
}
