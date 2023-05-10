package com.order.repository;
import com.order.api.repository.AccountRepository;
import com.order.model.Account;
import com.order.utils.ConnectionManager;
import com.order.utils.Mapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AccountRepositoryImpl implements AccountRepository {

    //todo delete
    @Deprecated
    private ArrayList<Account> accounts = new ArrayList<>();

    private final ConnectionManager connectionManager = ConnectionManager.getInstance();
//slf4g , log4g
    //lombok
    @Override
    public Account addAccount(Account account) {
        var connection = connectionManager.getConnection();
        var query = "INSERT account( accountName, phoneNumber) VALUES (?, ?)";
        try(var statement  = connection.prepareStatement(query)){
            statement.setString(1, account.getAccountName());
            statement.setString(2, account.getPhoneNumber());
            statement.executeUpdate();

            return account;

        }catch (SQLException e){
            throw new RuntimeException(e);

        }
    }

    @Override
    public Account getAccount(UUID id) {
        var query = "select * from account where idAccount = 1";
        var connection = connectionManager.getConnection();
        try(var statement = connection.prepareStatement(query)) {
            // statement.setString(1, "1");
            var resultSet = statement.executeQuery();
            Mapper mapper = new Mapper(resultSet);
            return mapper.getAccount();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteAccountById(UUID id) {
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
        var connection = connectionManager.getConnection();
        var query = "SELECT * FROM account";
        try(var statement  = connection.prepareStatement(query)){
            var resultSet = statement.executeQuery();
            Mapper mapper = new Mapper(resultSet);
            return mapper.getAccounts();


        }catch (SQLException e){
            System.out.println("Can't delete account: " + e.getMessage());
            throw new RuntimeException(e);
        }
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
