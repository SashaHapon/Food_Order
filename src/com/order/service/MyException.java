package com.order.service;

public class MyException extends java.lang.Exception {
    private int number;
    public int getNumber(){return number;}
    public MyException(String message, int num){

        super(message);
        number=num;
    }
}
