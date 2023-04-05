import com.order.api.repository.AccountRepository;
import com.order.api.repository.MealRepository;
import com.order.api.service.AccountService;
import com.order.api.service.MealService;
import com.order.repository.AccountRepositoryImpl;
import com.order.repository.MealRepositoryImpl;
import com.order.service.AccountServiceImpl;
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

        AccountRepository accountRepository = new AccountRepositoryImpl();
        AccountService accountService = new AccountServiceImpl(accountRepository);

        var account = accountService.addAccount("Jack", 20,"+375449394875");
        System.out.println(account);
        accountService.update("Jin", "+34824",  account.getId());
        System.out.println(account);

    }
}