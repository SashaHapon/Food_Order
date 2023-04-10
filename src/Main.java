import com.order.api.repository.AccountRepository;
import com.order.api.repository.MealRepository;
import com.order.api.service.AccountService;
import com.order.api.service.MealService;
import com.order.api.service.Wallet;
import com.order.repository.AccountRepositoryImpl;
import com.order.repository.MealRepositoryImpl;
import com.order.service.AccountServiceImpl;
import com.order.service.MealServiceImpl;
import com.order.service.OrderImpl;
import com.order.service.WalletServiceImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        MealRepository mealRepository = new MealRepositoryImpl();
        MealService mealService = new MealServiceImpl(mealRepository);

        AccountRepository accountRepository = new AccountRepositoryImpl();
        AccountService accountService = new AccountServiceImpl(accountRepository);

        Properties properties = new Properties();
        FileInputStream in = new FileInputStream("src/resources/config.property");
        properties.load(in);

        Wallet wallet = new WalletServiceImpl(accountService);

        var account = accountService.addAccount("Jack", 20,"+375449394875");

        var meal = mealService.addMeal("sosiski", 200, 5);
        var meal1 = mealService.addMeal("makaroshki", 200, 10);
        var meal2 = mealService.addMeal("Potatos", 65, 20);
        var meals = mealService.getAll();

        OrderImpl order = new OrderImpl(mealService,accountService,wallet,account.getId());

        order.setAccount(account.getId());

        order.addMeal(meal2);
        order.addMeal(meal);
        order.addMeal(meal1);

        order.orderSum();
        order.applyDiscount(properties.getProperty("discount"));
        order.checkPayment();
    }
}