import com.order.api.repository.MealRepository;
import com.order.api.service.MealService;
import com.order.repository.MealRepositoryImpl;
import com.order.service.MealServiceImpl;

public class Main {
    public static void main(String[] args) {
        MealRepository mealRepository = new MealRepositoryImpl();
        MealService mealService = new MealServiceImpl(mealRepository);

        var meal = mealService.addMeal("sosiski", 200, 5);
        var meal1 = mealService.addMeal("makaroshki", 200, 10);
        var meals = mealService.getAll();
        System.out.println(meals);

        System.out.println(meal.getNameOfMeal());
        System.out.println(meal1.getId());





    }
}