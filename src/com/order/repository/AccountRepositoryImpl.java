package com.order.repository;

import com.order.api.repository.AccountRepository;
import com.order.model.Account;
import com.order.utils.ConnectionManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AccountRepositoryImpl implements AccountRepository {

    //todo delete
    @Deprecated
    private ArrayList<Account> accounts = new ArrayList<>();

    private final ConnectionManager connectionManager = ConnectionManager.getInstance();

    @Override
    public Account addAccount(Account account) {
        var connection = connectionManager.getConnection();
        var query = "INSERT account( accountName, phoneNumber) VALUES (?, ?)";
        try(var statement  = connection.prepareStatement(query)){
            statement.setString(1, account.getAccountName());
            statement.setString(2, account.getPhoneNumber());
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println("Can't add account: " + e.getMessage());
        }



            account.setId(UUID.randomUUID());
            accounts.add(account);
            return account;
    }

    @Override
    public Account getAccount(UUID id) {
        var query = "select * from account where idAccount = 1";
        var connection = connectionManager.getConnection();
        try(var statement = connection.prepareStatement(query)) {
            // statement.setString(1, "1");
            var resultSet = statement.executeQuery();
            //todo move to mapper
            var account = new Account();
            account.setId(UUID.fromString(resultSet.getString("idAccount")));
            account.setAccountName(resultSet.getString("accountName"));
            account.setPhoneNumber(resultSet.getString("phoneNumber"));

            return account;
        } catch (SQLException e) {
            //todo throw DatatbaseException(e)
            System.out.println("Ошибка подключения к базе данных: " + e.getMessage());

        }
        return null;
    }

    @Override
    public void deleteAccountById(UUID id) {
    /*    var  account = accounts.stream()
                .filter(c -> id.equals(c.getId()))
                .findFirst().
                orElseThrow(() -> new RuntimeException("Account not found"));
        accounts.remove(account);
    */
        var connection = connectionManager.getConnection();
        var query = "DELETE FROM account WHERE idAccount = ?";
        try(var statement  = connection.prepareStatement(query)){
            statement.setString(1, "15");
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println("Can't delete account: " + e.getMessage());
        }


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
