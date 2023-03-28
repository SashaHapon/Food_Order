package com.user;

public interface IAccount {
    void setAccount(String accountName, double moneyOnCard, String phoneNumber);

    String getAccountName(int index);

    void enrollmentMoney(double moneyOnCard, int index);

    void writeOffMoneyOnCard(double moneyOnCard, int index);

    double getMoneyOnCard(int index);
}
