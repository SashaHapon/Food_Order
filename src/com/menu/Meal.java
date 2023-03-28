package com.menu;

public class Meal {
    String nameOfMeal;
    double priceOfMeal;
    int cookingTime;
    String createData;

    public Meal(String nameOfMeal, double priceOfMeal, int cookingTime){
        this.nameOfMeal = nameOfMeal;
        this.priceOfMeal = priceOfMeal;
        this.cookingTime = cookingTime;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "nameOfMeal='" + nameOfMeal + '\'' +
                ", priceOfMeal=" + priceOfMeal +
                ", cookingTime=" + cookingTime +
                ", createData='" + createData + '\'' +
                '}';
    }

    /*  public void setNameOfMeal(String nameOfMeal) {
       this.nameOfMeal = nameOfMeal;
    }

   public void setPriceOfMeal(double priceOfMeal) {
       this.priceOfMeal = priceOfMeal;
    }

    public void setCookingTime(byte cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getNameOfMeal() {
        return nameOfMeal;
    }

    public double getPriceOfMeal() {
        return priceOfMeal;
    }

    public byte getCookingTime() {
        return cookingTime;
    }

 */
}
