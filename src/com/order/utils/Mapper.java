package com.order.utils;

import com.order.model.Account;

import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
