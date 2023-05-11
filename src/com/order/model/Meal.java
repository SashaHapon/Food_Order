package com.order.model;

import java.util.UUID;

public class Meal {
    private String nameOfMeal;
    private double priceOfMeal;
    private int cookingTime;
    private String createDate;
    private Long id;

    public Meal(){};

    public Meal(String nameOfMeal, double priceOfMeal, int cookingTime){
        this.nameOfMeal = nameOfMeal;
        this.priceOfMeal = priceOfMeal;
        this.cookingTime = cookingTime;
    }
    public Meal(String nameOfMeal, double priceOfMeal, int cookingTime, Long id){
        this.nameOfMeal = nameOfMeal;
        this.priceOfMeal = priceOfMeal;
        this.cookingTime = cookingTime;
        this.id = id;
    }



    public void setNameOfMeal(String nameOfMeal) {
       this.nameOfMeal = nameOfMeal;
    }

   public void setPriceOfMeal(double priceOfMeal) {
       this.priceOfMeal = priceOfMeal;
    }

    public void setCookingTime(int cookingTime) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Long getId() {
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
