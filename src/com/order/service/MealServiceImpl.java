package com.order.service;

import com.order.api.repository.MealRepository;
import com.order.api.service.MealService;
import com.order.model.Meal;

import java.util.List;
import java.util.UUID;

public class MealServiceImpl implements MealService {
        private MealRepository mealRepository;

        public MealServiceImpl(MealRepository mealRepository) {
                this.mealRepository = mealRepository;
        }

        @Override
        public List<Meal> getAll(){
                return mealRepository.getAllMeal();
        }

        @Override
        public Meal addMeal(String nameOfMeal, double priceOfMeal, int cookingTime){
                return mealRepository.addMeal(new Meal(nameOfMeal,priceOfMeal,cookingTime));
        }
        @Override
        public Meal getMeal(UUID id){
             return mealRepository.getMeal(id);
        }

        @Override
        public void deleteMealById(UUID id) {
                mealRepository.deleteMealById(id);
        }

        @Override
        public void update(String nameOfMeal, double priceOfMeal, int cookingTime, UUID idChengingMeal) {
                mealRepository.update(nameOfMeal,priceOfMeal,cookingTime,idChengingMeal);
        }



}
