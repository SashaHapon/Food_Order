package com.cafe;

import com.menu.IMenu;
import com.menu.Meal;

import java.util.ArrayList;

public interface ICafe {
    void setCafe(String nameOfCafe, int numberOfTables);

    void setMenu(IMenu menu);

    ArrayList<Meal> getMenu();

    String toString();
}
