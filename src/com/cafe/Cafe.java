package com.cafe;
import com.menu.IMenu;
import com.menu.Meal;

import java.util.ArrayList;

public class Cafe implements ICafe {
    String nameOfCafe;
    int numberOfTables;
    ArrayList<Meal> menu;

    public Cafe(){}
    @Override
    public void setCafe(String nameOfCafe, int numberOfTables){
        this.nameOfCafe = nameOfCafe;
        this.numberOfTables = numberOfTables;
    }
    @Override
    public void setMenu(IMenu menu) {
        this.menu = menu.getMenu();
    }
    @Override
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
