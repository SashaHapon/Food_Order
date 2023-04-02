package com.order.model;

import java.util.UUID;

public class Meal {
    private String nameOfMeal;
    private double priceOfMeal;
    private int cookingTime;
    private String createDate;
    private UUID id;

    public Meal(String nameOfMeal, double priceOfMeal, int cookingTime){
        this.nameOfMeal = nameOfMeal;
        this.priceOfMeal = priceOfMeal;
        this.cookingTime = cookingTime;
    }



    public void setNameOfMeal(String nameOfMeal) {
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

    public int getCookingTime() {
        return cookingTime;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
    public String toString() {
        return "Meal{" +
                "nameOfMeal='" + nameOfMeal + '\'' +
                ", priceOfMeal=" + priceOfMeal +
                ", cookingTime=" + cookingTime +
                ", createData='" + createDate + '\'' +
                '}';
    }
}
