package com.order.utils;

import com.order.utils.annotation.ConfigProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



@ConfigProperty(url = "jdbc:mysql://localhost:3306/mydb",
        user = "root",
        password = "12345")
public class ConnectionManager {

    //todo get connection method

    //todo implement pattern singltone
   public String url;
    public String user;
    public String password;
    private Connection connection;
    private Properties properties = new Properties();
    private static ConnectionManager instance;

    Log log = new Log();

    private ConnectionManager(){};

    public static ConnectionManager getInstance(){
        if(instance == null){
            instance = new ConnectionManager();
        }

        return instance;
    };


    public Connection getConnection(){

        PropertyUtils property = new PropertyUtils();

        String url = property.getProperty("url");
        String user = property.getProperty("user");
        String password = property.getProperty("password");
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            log.error(e.getMessage());
            System.out.println("Ошибка подключения к базе данных: " + e.getMessage());
        }
        return connection;
    }
}
