package com.order.model;

import java.util.ArrayList;

public class Cafe {
    String nameOfCafe;
    int numberOfTables;
    ArrayList<Meal> menu;

    public Cafe(){}

    public void setCafe(String nameOfCafe, int numberOfTables){
        this.nameOfCafe = nameOfCafe;
        this.numberOfTables = numberOfTables;
    }
    public ArrayList<Meal> getMenu() {
        return menu;
    }


    public String toString() {
        return "Cafe{" +
                "nameOfCafe='" + nameOfCafe + '\'' +
                ", numberOfTables=" + numberOfTables +
                ", menu=" + menu +
                '}';
    }
}
