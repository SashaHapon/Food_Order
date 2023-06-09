package com.order.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "account")
public class Account {
    @Column (name = "accountName")
   private String accountName;
    @Column (name = "moneyOnCard")
    private double moneyOnCard;
    @Column (name = "phoneNumber")
    private String phoneNumber;
    @Id
    @Column (name = "idAccount")
    private Long id;

    private String idw;

    public Account(){};
    public Account(String accountName, double moneyOnCard, String phoneNumber){
        this.accountName = accountName;
        this.moneyOnCard = moneyOnCard;
        this.phoneNumber = phoneNumber;
        this.idw = idRandomizer();
    }
    public Account(String accountName, String phoneNumber, Long id){
        this.accountName = accountName;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    private String idRandomizer(){
       String id  = String.valueOf(UUID.randomUUID());
        System.out.println(id);
       return id;
    }

    public String getIdw() {
        return idw;
    }

    public void setIdw(String idw) {
        this.idw = idw;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
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
