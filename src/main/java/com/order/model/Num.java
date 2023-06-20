package com.order.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "num", schema = "mydb")
public class Num {
    @Id
    int one;
    String two;
    String three;

    public  Num(){};
    public Num(int one, String two, String three) {
        this.one = one;
        this.two = two;
        this.three = three;
    }

    public int getOne() {
        return one;
    }

    public void setOne(int one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three;
    }

}
