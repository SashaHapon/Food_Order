package com.order.api.repository;
import com.order.model.Account;

import java.util.List;

public interface AccountRepository {
    Account addAccount(Account account);

    Account getAccount(int index);

    void deleteAccountById(Long id);

    List<Account> getAllAccounts();

    void update(Account account);
}
