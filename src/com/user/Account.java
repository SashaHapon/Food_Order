package com.user;

import java.util.ArrayList;

public class Account implements IAccount {
    public int sIndex;
    ArrayList<Account> account = new ArrayList<>();
    String accountName;
    double moneyOnCard;
    String phoneNumber;
    String index;

    public Account(){};
    Account(String accountName, double moneyOnCard, String phoneNumber, String index){
        this.accountName = accountName;
        this.moneyOnCard = moneyOnCard;
        this.phoneNumber = phoneNumber;
        this.index = index();
    }

    @Override
    public void setAccount(String accountName, double moneyOnCard, String phoneNumber){
        Account account1 = new Account(accountName, moneyOnCard, phoneNumber, index());
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
    @Override
    public String toString(int index) {
        return "Account{" +
                "accountName='" + account.get(index).accountName + '\'' +
                ", moneyOnCard=" + account.get(index).moneyOnCard +
                ", phoneNumber='" + account.get(index).phoneNumber + '\'' +
                ", index='" + account.get(index).index + '\'' +
                '}';
    }
}
