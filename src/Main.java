import com.order.api.repository.AccountRepository;
import com.order.api.repository.MealRepository;
import com.order.api.repository.OrderRepository;
import com.order.api.service.*;
import com.order.repository.AccountRepositoryImpl;
import com.order.repository.MealRepositoryImpl;
import com.order.repository.OrderRepositoryImpl;
import com.order.service.*;
import com.order.service.MyException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

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

        OrderRepository orderRepository = new OrderRepositoryImpl();
        OrderService orderService = new OrderServiceImpl(orderRepository);

        var order = orderService.createOrder(account, mealRepository.getAllMeal());
        UUID orderId = order.getId();
        orderService.addMeal(meal, orderId);
        orderService.addMeal(meal1, orderId);
        orderService.getAllMeals(orderId);
        orderService.applyDiscount(properties.getProperty("discount"), orderId);
        orderService.checkPayment(orderId);



    }
}