package com.order.repository;

import com.order.api.repository.AccountRepository;
import com.order.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AccountRepositoryImpl implements AccountRepository {

    private ArrayList<Account> accounts = new ArrayList<>();

    @Override
    public Account addAccount(Account account) {
        account.setId(UUID.randomUUID());
        accounts.add(account);
        return account;

    }

    @Override
    public Account getAccount(UUID id) {
        var account = accounts.stream().filter(c -> id.equals(c.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return account;
    }

    @Override
    public void deleteAccountById(UUID id) {
        var  account = accounts.stream()
                .filter(c -> id.equals(c.getId()))
                .findFirst().
                orElseThrow(() -> new RuntimeException("Meal not found"));
        accounts.remove(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts);
    }

    @Override
    public void update(String name, String phone, UUID idChengingAccount) {
        var account = accounts.stream().filter(c -> idChengingAccount.equals(c.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.setAccountName(name);
        account.setPhoneNumber(phone);
    }
}
