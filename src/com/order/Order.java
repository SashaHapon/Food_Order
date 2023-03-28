package com.order;

import com.cafe.ICafe;
import com.menu.Meal;
import com.user.IAccount;

public class Order implements IOrder{

    @Override
    public  void setAccountsParameters(IAccount account){
        account.setAccountName("Alex");
        account.enrollmentMoney(0, 0);
    }
    @Override
    public void setCafeParameters(ICafe cafe) {
        cafe.setCafe("Roze", 50);
    }

    @Override
    public Meal choizeOfMeal(ICafe cafe, int i){
        return cafe.getMenu().get(i);

    }
    @Override
    public String getAccountName(IAccount account, int index) {
        return account.getAccountName(index);
    }

    @Override
    public void getMoneyOnCard(IAccount account) {

    }

    @Override
    public void checkMoneyAndPrice(IAccount account) {

    }

    @Override
    public void writeOffMoneyForOrder(IAccount account) {

    }




    @Override
    public void getOrder() {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
