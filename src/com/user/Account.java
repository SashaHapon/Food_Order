package com.user;

import java.util.ArrayList;

public class Account implements IAccount {
    int sIndex = 0;
    ArrayList<Account> account = new ArrayList<>();
    String accountName;
    double moneyOnCard;
    String phoneNumber;
    String index;

    public Account(){};
    Account(String accountName, double moneyOnCard, String phoneNumber){
        this.accountName = accountName;
        this.moneyOnCard = moneyOnCard;
        this.phoneNumber = phoneNumber;
        this.index = index();
    }

    @Override
    public void setAccount(String accountName, double moneyOnCard, String phoneNumber){
        Account account1 = new Account(accountName, moneyOnCard, phoneNumber);
        account.add(account1);
    }

    @Override
    public String getAccountName(int index){
        return account.get(index).accountName;
    }
    @Override
    public double getMoneyOnCard(int index) {
        return account.get(index).moneyOnCard;
    }
    @Override
    public void enrollmentMoney(double moneyOnCard, int index) {
        account.get(index).moneyOnCard += moneyOnCard;
    }
    @Override
    public void writeOffMoneyOnCard(double moneyOnCard, int index) {
        account.get(index).moneyOnCard += moneyOnCard;
    }

     public String index(){
        sIndex++;
        String newIndex = "index" + Integer.toString(sIndex);
      return newIndex;
     }
}
