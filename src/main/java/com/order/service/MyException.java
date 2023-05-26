package com.order.service;
import java.lang.Exception;
public class MyException extends RuntimeException {
    private int number;

    public int getNumber() {
        return number;
    }

    public MyException(String message, int num) {

        super(message);
        number = num;
    }
}
