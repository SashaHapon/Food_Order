package com.order.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtils {
    public String getProperty(String stringKey){
        Properties properties = new Properties();

        try(
            FileInputStream in = new FileInputStream("src/main/java/resources/properties/config.property");
            )
        {
            properties.load(in);
        }catch (Exception e){

        }
        return properties.getProperty(stringKey);
    }
}
