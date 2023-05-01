package com.order.utils;

import java.sql.Connection;

public class ConnectionManager {

    //todo get connection method

    //todo implement pattern singltone
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }
}
