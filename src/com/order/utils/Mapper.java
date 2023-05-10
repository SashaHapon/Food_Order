package com.order.utils;

import com.order.model.Account;

import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Mapper {
    private ResultSet resultSet;
    private Statement statement;
    public Mapper(ResultSet resultSet){
        this.resultSet = resultSet;
    }

    public Account getAccount() throws SQLException {
        Account account = new Account();
        resultSet.next();
        account.setId(resultSet.getLong("idAccount"));
        account.setAccountName(resultSet.getString("accountName"));
        account.setPhoneNumber(resultSet.getString("phoneNumber"));
        return account;
    }

    public List<Account> getAccounts() throws  SQLException{
        int j = 1;
        List <Account> array = new ArrayList<>();
        while (resultSet.next()){
            Account account = new Account();
            account.setId(resultSet.getLong("idAccount"));
            account.setAccountName(resultSet.getString("accountName"));
            account.setPhoneNumber(resultSet.getString("phoneNumber"));
            array.add(account);
            j++;
        }
        return array;
    }

}
