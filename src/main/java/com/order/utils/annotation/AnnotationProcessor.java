package com.order.utils.annotation;

import com.order.utils.ConnectionManager;

import java.lang.reflect.Field;

public class AnnotationProcessor {
    public static void inspectService(Class<?> cl) throws NoSuchFieldException {
        Object ob = ConnectionManager.getInstance();
        ConfigProperty configProperty = ob.getClass().getAnnotation(ConfigProperty.class);
        try{
            Field field = cl.getDeclaredField("url");
            field.setAccessible(true);
            field.set(ob, configProperty.url());

            Field field1 = cl.getDeclaredField("user");
            field1.setAccessible(true);
            field1.set(ob, configProperty.user());

            Field field12 = cl.getDeclaredField("password");
            field12.setAccessible(true);
            field12.set(ob, configProperty.password());

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
