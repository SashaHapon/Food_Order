package com.order.model;

import java.util.ArrayList;

public class Cafe {
    private String nameOfCafe;
    private int numberOfTables;
    private ArrayList<Meal> menu;
    public Cafe(String nameOfCafe, int numberOfTables){
        this.nameOfCafe = nameOfCafe;
        this.numberOfTables = numberOfTables;
    }
    public ArrayList<Meal> getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        return "Cafe{" +
                "nameOfCafe='" + nameOfCafe + '\'' +
                ", numberOfTables=" + numberOfTables +
                ", menu=" + menu +
                '}';
    }
}
