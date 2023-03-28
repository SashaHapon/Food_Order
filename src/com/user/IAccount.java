package com.user;

public interface IAccount {
    void setAccountName(String accountName);

    String getAccountName();

    void enrollmentMoney(double moneyOnCard);

    void writeOffMoneyOnCard(double moneyOnCard);

    double getMoneyOnCard();
}
