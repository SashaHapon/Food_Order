import com.order.api.repository.AccountRepository;
import com.order.api.repository.MealRepository;
import com.order.api.service.*;
import com.order.model.Order;
import com.order.repository.AccountRepositoryImpl;
import com.order.repository.MealRepositoryImpl;
import com.order.service.*;
import com.order.service.MyException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException, MyException {

        MealRepository mealRepository = new MealRepositoryImpl();
        MealService mealService = new MealServiceImpl(mealRepository);

        AccountRepository accountRepository = new AccountRepositoryImpl();
        AccountService accountService = new AccountServiceImpl(accountRepository);

        Properties properties = new Properties();
        FileInputStream in = new FileInputStream("src/resources/properties/config.property");
        properties.load(in);

        WalletService walletService = new WalletServiceImpl(accountService);

        var account = accountService.addAccount("Jack", 100,"+375449394875");

        var meal = mealService.addMeal("sosiski", 200, 5);
        var meal1 = mealService.addMeal("makaroshki", 200, 10);
        var meal2 = mealService.addMeal("Potatos", 65, 20);




    }
}