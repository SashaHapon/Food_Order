import com.order.api.repository.AccountRepository;
import com.order.api.repository.MealRepository;
import com.order.api.service.*;
import com.order.repository.AccountRepositoryImpl;
import com.order.repository.MealRepositoryImpl;
import com.order.service.*;
import com.order.service.Exception;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException, Exception {

        MealRepository mealRepository = new MealRepositoryImpl();
        MealService mealService = new MealServiceImpl(mealRepository);

        AccountRepository accountRepository = new AccountRepositoryImpl();
        AccountService accountService = new AccountServiceImpl(accountRepository);

        Properties properties = new Properties();
        FileInputStream in = new FileInputStream("src/resources/properties/config.property");
        properties.load(in);

        WalletService wallet = new WalletServiceImpl(accountService);

        var account = accountService.addAccount("Jack", 100,"+375449394875");

        var meal = mealService.addMeal("sosiski", 200, 5);
        var meal1 = mealService.addMeal("makaroshki", 200, 10);
        var meal2 = mealService.addMeal("Potatos", 65, 20);

        OrderService order = new OrderServiceImpl(mealService,accountService,wallet,account.getId());

        order.setAccount(account.getId());

        order.addMeal(meal2);
        order.addMeal(meal);
        order.addMeal(meal1);

        order.orderSum();
        order.applyDiscount(properties.getProperty("discount"));
        order.checkPayment();
        order.cookingTimeSum();


    }
}