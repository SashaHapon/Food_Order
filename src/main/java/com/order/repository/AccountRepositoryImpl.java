package com.order.repository;

import com.order.api.repository.AccountRepository;
import com.order.model.Account;
import com.order.service.MyException;
import com.order.utils.Log;
import com.order.utils.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import static com.order.utils.ConnectionManager.getConnection;

public class AccountRepositoryImpl implements AccountRepository {
    Log log = new Log();
//    private final ConnectionManager connectionManager = ConnectionManager.getInstance();
//slf4g , log4g
    //lombok
    @Override
    public Account addAccount(Account account) {
        var connection = getConnection();
        var query = "INSERT account(id, name, phone_number) VALUES (?, ?, ?)";
        try(var statement  = connection.prepareStatement(query)){
            statement.setString(1, String.valueOf(account.getId()));
            statement.setString(2, account.getName());
            statement.setString(3, account.getPhoneNumber());
            statement.executeUpdate();
            return account;
        }catch (SQLException e){

            throw new MyException(e.getMessage() + ": Can't add account");
        }
    }

    @Override
    public Account getAccount(UUID id) {
        var query = "select * from account where idAccount = ?";
        var connection = getConnection();
        try(var statement = connection.prepareStatement(query)) {
            statement.setString(1, String.valueOf(id));
            var resultSet = statement.executeQuery();
            Mapper mapper = new Mapper();
            return mapper.getAccount(resultSet);
        } catch (SQLException e) {

            throw new MyException(e.getMessage() + ": Can't get account");
        }
    }

    @Override
    public void deleteAccountById(UUID id) {
        var connection = getConnection();
        var query = "DELETE FROM account WHERE idAccount = ?";
        try(var statement  = connection.prepareStatement(query)){
            statement.setString(1, String.valueOf(id));
            statement.executeUpdate();
        }catch (SQLException e){

            log.error("Can't delete account: " + e.getMessage());
            throw new MyException(e.getMessage() + ": Can't get account");
        }
    }

    @Override
    public List<Account> getAllAccounts() {
        var connection = getConnection();
        var query = "SELECT * FROM account";
        try(var statement  = connection.prepareStatement(query)){
            var resultSet = statement.executeQuery();
            Mapper mapper = new Mapper();
            return mapper.getAccounts(resultSet);
        }catch (SQLException e){

            throw new MyException(e.getMessage() + ": Can't get accounts");
        }
    }

    @Override
    public void update(String name, String phone, String id) {
        var connection = getConnection();
        try (var statement = connection.prepareStatement("UPDATE account SET accountName = ?, phoneNumber = ? WHERE idAccount = ?")) {
            statement.setString(1, name);
            statement.setString(2, phone);
            statement.setString(3, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new MyException(e.getMessage() + ": Can't update account");
        }
    }
}
