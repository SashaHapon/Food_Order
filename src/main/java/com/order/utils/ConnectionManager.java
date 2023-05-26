package com.order.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    //todo get connection method

    //todo implement pattern singltone
    private Connection connection;
    private Properties properties = new Properties();
    private static ConnectionManager instance;

    private ConnectionManager(){};

    public static ConnectionManager getInstance(){
        if(instance == null){
            instance = new ConnectionManager();
        }

        return instance;
    };

    public Connection getConnection(){
        try {
            FileInputStream in = new FileInputStream("src/main/java/resources/properties/config.property");
            properties.load(in);
        } catch (IOException e){

        };

        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к базе данных: " + e.getMessage());
        }
        return connection;
    }
}
