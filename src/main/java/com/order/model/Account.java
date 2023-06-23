package com.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

// TODO: 23.06.2023 Fix::java.sql.SQLIntegrityConstraintViolationException: Duplicate entry
@Entity
@Table(name = "account", schema = "mydb")
public class Account {
    @Id
    private String id;
    private String name;
    private Double money;
    @Column(name = "phone_number")
    private String phoneNumber;
    public Account(){};
    public Account(String accountName, double moneyOnCard, String phoneNumber){
        this.name = accountName;
        this.money = moneyOnCard;
        this.phoneNumber = phoneNumber;
        this.id = idRandomizer();
    }
    public Account(String accountName, String phoneNumber, Long id){
        this.name = accountName;
        this.phoneNumber = phoneNumber;
        this.id = id.toString();
    }

    private String idRandomizer(){
       String id  = String.valueOf(UUID.randomUUID());
        System.out.println(id);
        id = "23134";
       return id;
    }

    public String getIdw() {
        return id;
    }

    public void setIdw(String idw) {
        this.id = idw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(Long id) {
        this.id = id.toString();
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + name + '\'' +
                ", moneyOnCard=" + money +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", id=" + id +
                '}';
    }
}
