package com.order.service;

public class Exception extends java.lang.Exception {
    private int number;
    public int getNumber(){return number;}
    public Exception(String message, int num){

        super(message);
        number=num;
    }
}
