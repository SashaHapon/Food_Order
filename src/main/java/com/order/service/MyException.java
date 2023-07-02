package com.order.service;

public class MyException extends RuntimeException {
    private int number;

    public int getNumber() {
        return number;
    }

    public MyException(String message) {

        super(message);

    }
}
