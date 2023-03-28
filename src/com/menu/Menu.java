package com.menu;

import java.util.ArrayList;

public class Menu implements IMenu {
    @Override
    public ArrayList<Meal> getMenu() {
        ArrayList<Meal> menu = new ArrayList<>();
        Meal eggs = new Meal("eggs",34.5,54);
        Meal gt = new Meal("2", 34.3,42);
        Meal third = new Meal("2", 45.3, 43);
        menu.add(eggs);
        menu.add(gt);
        menu.add(third);
        return menu;
    }

}
