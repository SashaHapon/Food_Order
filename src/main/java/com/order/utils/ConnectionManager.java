package com.order.utils;

import com.order.service.MyException;
import com.order.utils.annotation.ConfigProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static com.order.utils.PropertyUtils.getProperty;


@ConfigProperty(url = "jdbc:mysql://localhost:3306/mydb",
        user = "root",
        password = "12345")
public class ConnectionManager {

    //todo get connection method

    //todo implement pattern singltone
    private static String url;

    private static String user;

    private static String password;

    private static Connection connection;

    private Properties properties = new Properties();
    private static ConnectionManager instance;

    static Log log = new Log();

    private ConnectionManager(){};

    public static ConnectionManager getInstance(){
        if(instance == null){
            instance = new ConnectionManager();
        }
        return instance;
    };

    private static Connection createConnection(){
                String url = getProperty(getUrl());
        String user = getProperty(getUser());
        String password = getProperty(getPassword());
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            log.error(e.getMessage());
            System.out.println("Ошибка подключения к базе данных: " + e.getMessage());
        }

        return connection;
    }

    public static Connection getConnection() {
        try{
            if(connection.isClosed() ==  false){
                return connection;
            }else{
                createConnection();
                return connection;
            }
        }catch (SQLException e){
            throw new MyException(e.getMessage() + "Can't get connection.");
        }
    }

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }
}
