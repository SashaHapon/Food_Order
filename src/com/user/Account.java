package com.user;

public class Account implements IAccount {
    String accountName;
    double moneyOnCard;
    String phoneNumber;
    public Account(){};
    Account(String accountName, double moneyOnCard, String phoneNumber){
        this.accountName = accountName;
        this.moneyOnCard = moneyOnCard;
        this.phoneNumber = phoneNumber;
    }
    @Override
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    @Override
    public String getAccountName() {
        return accountName;
    }
    @Override
    public void enrollmentMoney(double moneyOnCard) {
        this.moneyOnCard += moneyOnCard;
    }
    @Override
    public void writeOffMoneyOnCard(double moneyOnCard) {
        this.moneyOnCard -= moneyOnCard;
    }
    @Override
    public double getMoneyOnCard() {
        return moneyOnCard;
    }
}
