package com.order.utils;

import com.order.service.MyException;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtils {
    private static Properties properties;

    public PropertyUtils(){
        this.properties = new Properties();

        try(
                FileInputStream in = new FileInputStream("src/main/java/resources/properties/config.property");
        )
        {
            properties.load(in);
        }catch (Exception e){
            throw new MyException(e.getMessage() + ": can't load properties");
        }
    }

//    public String getProperty(String stringKey){
//        Properties properties = new Properties();
//
//        try(
//            FileInputStream in = new FileInputStream("src/main/java/resources/properties/config.property");
//            )
//        {
//            properties.load(in);
//        }catch (Exception e){
//
//        }
//        return properties.getProperty(stringKey);
//    }
    public static String getProperty(String stringKey){
        return properties.getProperty(stringKey);
    }
}
