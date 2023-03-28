package com.order;

import com.cafe.ICafe;
import com.menu.Meal;
import com.user.IAccount;

public interface IOrder {
    void getOrder();

    void setAccountsParameters(IAccount account);

    void cafe(ICafe cafe);

    Meal choizeOfMeal(ICafe cafe, int i);

    String getAccountName(IAccount account);

    void getMoneyOnCard(IAccount account);

    void checkMoneyAndPrice(IAccount account);
    void writeOffMoneyForOrder(IAccount account);

}
