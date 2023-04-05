package com.order.model;

import java.util.UUID;

public class Account {
   private String accountName;
    private double moneyOnCard;
    private String phoneNumber;
    private UUID id;

    public Account(){};
    public Account(String accountName, double moneyOnCard, String phoneNumber){
        this.accountName = accountName;
        this.moneyOnCard = moneyOnCard;
        this.phoneNumber = phoneNumber;
    }
    public Account(String accountName, String phoneNumber, UUID id){
        this.accountName = accountName;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getMoneyOnCard() {
        return moneyOnCard;
    }

    public void setMoneyOnCard(double moneyOnCard) {
        this.moneyOnCard = moneyOnCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", moneyOnCard=" + moneyOnCard +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", id=" + id +
                '}';
    }
}
