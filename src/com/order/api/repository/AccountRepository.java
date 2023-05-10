package com.order.api.repository;
import com.order.model.Account;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface AccountRepository {
    Account addAccount(Account account) throws IOException;
    Account getAccount(UUID id);
    void deleteAccountById(UUID id);
    List<Account> getAllAccounts();
    void update(String name, String phone, String idChengingAccount);

}
